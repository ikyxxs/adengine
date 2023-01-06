package com.ikyxxs.adengine.controller;

import cn.hutool.core.util.RandomUtil;
import com.ikyxxs.adengine.domain.RequestThreadLocal;
import com.ikyxxs.adengine.domain.Result;
import com.ikyxxs.adengine.domain.ResultBuilder;
import com.ikyxxs.adengine.domain.vo.AdvertVO;
import com.ikyxxs.adengine.service.engine.AdvertEngineService;
import com.ikyxxs.adengine.utils.InnerLogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ikyxxs.adengine.enums.InnerLogType.ADVERT_REQUEST;

/**
 * 广告投放接口
 *
 * @author 木白
 * @date 2022/05/11
 */
@RestController
public class AdvertEngineController {

    @Autowired
    private AdvertEngineService advertEngineService;

    /**
     * 请求广告
     */
    @CrossOrigin
    @GetMapping("/getAdvert")
    public Result<AdvertVO> getAdvert() {
        // 记录广告请求日志
        InnerLogUtils.log(ADVERT_REQUEST, InnerLogUtils.buildJSON());

        // 生成订单号
        String orderId = RandomUtil.randomNumbers(8);
        RequestThreadLocal.get().setOrderId(orderId);

        // 获取广告
        AdvertVO advertVO = advertEngineService.getAdvert();
        return ResultBuilder.success(advertVO);
    }
}
