package com.ikyxxs.adengine.service.cache;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.ikyxxs.adengine.config.GlobalThreadPool;
import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;
import com.ikyxxs.adengine.domain.cache.MaterialCacheDto;
import com.ikyxxs.adengine.domain.entity.AdvertDO;
import com.ikyxxs.adengine.domain.entity.MaterialDO;
import com.ikyxxs.adengine.service.engine.AdvertService;
import com.ikyxxs.adengine.service.engine.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

/**
 * 广告缓存服务
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class AdvertCacheService implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(AdvertCacheService.class);

    @Autowired
    private AdvertService advertService;

    @Autowired
    private MaterialService materialService;

    /**
     * 广告本地缓存
     */
    private final LoadingCache<Long, Optional<AdvertCacheDto>> ADVERT_CACHE = CacheBuilder
            .newBuilder()
            .refreshAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<Long, Optional<AdvertCacheDto>>() {

                @Override
                public Optional<AdvertCacheDto> load(Long advertId) {
                    AdvertCacheDto advertCacheDto = buildAdvertCacheDto(advertId);
                    return Optional.ofNullable(advertCacheDto);
                }

                @Override
                public ListenableFuture<Optional<AdvertCacheDto>> reload(Long advertId, Optional<AdvertCacheDto> oldValue) {
                    ListenableFutureTask<Optional<AdvertCacheDto>> task = ListenableFutureTask.create(() -> load(advertId));
                    GlobalThreadPool.executorService.submit(task);
                    return task;
                }
            });

    /**
     * 查询所有广告缓存(返回的是可修改的拷贝对象)
     */
    public List<AdvertCacheDto> queryTotalAdvertCache() {
        return ADVERT_CACHE.asMap().values().stream()
                .filter(Optional::isPresent)
                .map(advertCacheDto -> advertCacheDto.get().copy())
                .collect(toList());
    }

    /**
     * 查询广告缓存(返回的是可修改的拷贝对象)
     */
    public List<AdvertCacheDto> queryAdvertCache(Long advertId) {
        return ADVERT_CACHE.asMap().values().stream()
                .filter(Optional::isPresent)
                .filter(advertCacheDto -> Objects.equals(advertCacheDto.get().getAdvertId(), advertId))
                .map(advertCacheDto -> advertCacheDto.get().copy())
                .collect(toList());
    }

    /**
     * 初始化广告引擎需要使用的缓存
     */
    private void initAdvertCache() {
        // 查询有效广告列表
        List<AdvertDO> validAdverts = advertService.selectValidAdverts();
        if (CollectionUtils.isEmpty(validAdverts)) {
            return;
        }

        // 查询广告信息并缓存
        ADVERT_CACHE.invalidateAll();
        Map<Long, List<MaterialDO>> materialMap = materialService.selectValidByAdvertIds(validAdverts.stream().map(AdvertDO::getId).collect(toList()));
        for (AdvertDO advert : validAdverts) {
            List<MaterialDO> materials = materialMap.get(advert.getId());
            if (CollectionUtils.isEmpty(materials)) {
                continue;
            }

            // 广告信息
            AdvertCacheDto advertCacheDto = convertTo(advert);
            // 可投素材列表
            advertCacheDto.setMaterialMap(buildMaterialMap(materials));
            ADVERT_CACHE.put(advert.getId(), Optional.of(advertCacheDto));
        }
    }

    /**
     * 构造广告缓存Dto
     */
    private AdvertCacheDto buildAdvertCacheDto(Long advertId) {
        AdvertDO advert = advertService.selectAdvertById(advertId);
        if (null == advert) {
            return null;
        }

        // 广告信息
        AdvertCacheDto advertCacheDto = convertTo(advert);

        // 广告可投素材
        Map<Long, List<MaterialDO>> materialMap = materialService.selectValidByAdvertIds(Collections.singletonList(advertId));
        if (!materialMap.containsKey(advertId)) {
            return null;
        }
        advertCacheDto.setMaterialMap(buildMaterialMap(materialMap.get(advertId)));
        return advertCacheDto;
    }

    /**
     * convert Advert to AdvertCacheDto
     */
    private AdvertCacheDto convertTo(AdvertDO advert) {
        AdvertCacheDto advertCacheDto = BeanUtil.copyProperties(advert, AdvertCacheDto.class);
        advertCacheDto.setAdvertId(advert.getId());
        advertCacheDto.setOrderFactor(buildOrderFactor(advert));
        return advertCacheDto;
    }

    /**
     * convert MaterialDO to MaterialCacheDto
     */
    private MaterialCacheDto convertTo(MaterialDO material) {
        MaterialCacheDto materialCacheDto = BeanUtil.copyProperties(material, MaterialCacheDto.class);
        materialCacheDto.setMaterialId(material.getId());
        return materialCacheDto;
    }

    /**
     * 根据素材权重构造TreeMap
     *
     * @param materials 素材列表
     * @return 素材TreeMap
     */
    private TreeMap<Integer, MaterialCacheDto> buildMaterialMap(List<MaterialDO> materials) {
        TreeMap<Integer, MaterialCacheDto> materialMap = new TreeMap<>();
        for (MaterialDO material : materials) {
            if (material.getWeight() < 1) {
                continue;
            }
            int lastWeight = materialMap.size() == 0 ? 0 : materialMap.lastKey();
            materialMap.put(material.getWeight() + lastWeight, convertTo(material));
        }
        return materialMap;
    }

    /**
     * 构造广告排序因子
     *
     * @param advert 广告
     * @return 排序因子
     */
    private Integer buildOrderFactor(AdvertDO advert) {
        return advert.getUnitPrice();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            log.info("AdvertCacheService.initAdvertCache started.");
            initAdvertCache();
            log.info("AdvertCacheService.initAdvertCache finished.");
        }
    }
}
