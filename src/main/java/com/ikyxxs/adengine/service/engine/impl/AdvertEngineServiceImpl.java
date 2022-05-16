package com.ikyxxs.adengine.service.engine.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ikyxxs.adengine.config.GlobalThreadPool;
import com.ikyxxs.adengine.domain.AdvertFilterContext;
import com.ikyxxs.adengine.domain.AdvertFilterReason;
import com.ikyxxs.adengine.domain.RequestThreadLocal;
import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;
import com.ikyxxs.adengine.domain.cache.MaterialCacheDto;
import com.ikyxxs.adengine.domain.entity.AdSnapshot;
import com.ikyxxs.adengine.domain.entity.OrderDO;
import com.ikyxxs.adengine.domain.vo.AdvertVO;
import com.ikyxxs.adengine.service.cache.AdvertCacheService;
import com.ikyxxs.adengine.service.engine.AdvertEngineService;
import com.ikyxxs.adengine.service.engine.OrderService;
import com.ikyxxs.adengine.service.filter.AdvertFilterHandler;
import com.ikyxxs.adengine.utils.InnerLogUtils;
import com.ikyxxs.adengine.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static com.ikyxxs.adengine.enums.InnerLogType.ADVERT_LAUNCH;

/**
 * 广告引擎接口实现
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class AdvertEngineServiceImpl implements AdvertEngineService {

    private static final Logger log = LoggerFactory.getLogger(AdvertEngineServiceImpl.class);
    private static final Logger advertFilterLog = LoggerFactory.getLogger("advert-filter");

    @Autowired
    private AdvertCacheService advertCacheService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AdvertFilterHandler advertFilterHandler;

    @Override
    public AdvertVO getAdvert() {
        Date today = DateUtil.beginOfDay(new Date());
        RequestThreadLocal threadLocal = RequestThreadLocal.get();
        Long appId = threadLocal.getAppId();
        String deviceId = threadLocal.getDeviceId();
        String orderId = threadLocal.getOrderId();

        // 获取所有可投广告缓存
        List<AdvertCacheDto> validAdverts = advertCacheService.queryTotalAdvertCache();
        if (CollectionUtils.isEmpty(validAdverts)) {
            return null;
        }

        // 过滤原因
        AdvertFilterReason filterReason = AdvertFilterReason.build(RequestThreadLocal.get());
        filterReason.setTotal(validAdverts.size());

        // 获取计费单价最高的可投广告
        AdvertCacheDto advert = validAdverts.stream()
                // 广告过滤
                .filter(ad -> {
                    AdvertFilterContext filterContext = new AdvertFilterContext();
                    filterContext.setAdvertCacheDto(ad);
                    filterContext.setAppId(appId);
                    filterContext.setToday(today);
                    filterContext.setFilterReason(filterReason);
                    return advertFilterHandler.doFilter(filterContext);
                })
                // 获取计费单价最高的广告
                .max(Comparator.comparing(AdvertCacheDto::getOrderFactor))
                .orElse(null);

        // 打印过滤原因日志
        advertFilterLog.info(JSON.toJSONString(filterReason));

        // 获取不到可投广告
        if (null == advert) {
            return null;
        }

        // 权重随机出素材
        int shuntHash = Math.abs(SecureUtil.md5(appId + deviceId).hashCode());
        MaterialCacheDto material = advert.randomMaterial(shuntHash);

        // 落地页处理
        String landpageUrl = handleLandpageUrl(advert.getLandpageUrl(), orderId);

        // 发券埋点
        JSONObject logJson = InnerLogUtils.buildJSON();
        logJson.put("orderId", orderId);
        logJson.put("advertId", advert.getAdvertId());
        logJson.put("materialId", material.getMaterialId());
        logJson.put("landpageUrl", landpageUrl);
        InnerLogUtils.log(ADVERT_LAUNCH, logJson);

        // 创建订单
        createOrder(orderId, advert, material.getMaterialId(), landpageUrl);

        // 返回广告和素材信息
        AdvertVO advertVO = BeanUtil.copyProperties(advert, AdvertVO.class);
        BeanUtil.copyProperties(material, advertVO);
        advertVO.setOrderId(orderId);
        advertVO.setLandpageUrl(landpageUrl);
        return advertVO;
    }

    /**
     * 创建订单
     */
    private void createOrder(String orderId, AdvertCacheDto advert, Long materialId, String landpageUrl) {
        OrderDO order = new OrderDO();
        order.setOrderId(orderId);
        order.setAppId(RequestThreadLocal.get().getAppId());
        order.setDeviceId(RequestThreadLocal.get().getDeviceId());
        order.setAdvertId(advert.getAdvertId());
        order.setMaterialId(materialId);

        // 广告额外信息
        AdSnapshot snapshot = new AdSnapshot();
        snapshot.setAdvertName(advert.getAdvertName());
        snapshot.setUnitPrice(advert.getUnitPrice());
        snapshot.setLandpageUrl(landpageUrl);
        order.setAdSnapshot(JSON.toJSONString(snapshot));

        // 订单落库
        GlobalThreadPool.executorService.execute(() -> orderService.saveOrder(order));
    }

    /**
     * 落地页处理
     *
     * @param originUrl 落地页原链接
     * @return 处理后的落地页链接
     */
    private String handleLandpageUrl(String originUrl, String orderId) {
        try {
            if (StrUtil.isBlank(originUrl)) {
                return originUrl;
            }

            Map<String, String> urlParam = new HashMap<>();
            urlParam.put("orderId", orderId);
            return UrlUtils.appendParams(originUrl, urlParam);
        } catch (Exception ignore) {}
        return originUrl;
    }
}
