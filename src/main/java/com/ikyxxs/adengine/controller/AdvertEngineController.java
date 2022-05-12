package com.ikyxxs.adengine.controller;

import com.ikyxxs.adengine.domain.RequestThreadLocal;
import com.ikyxxs.adengine.domain.Result;
import com.ikyxxs.adengine.domain.ResultBuilder;
import com.ikyxxs.adengine.utils.InnerLogUtils;
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

    /**
     * 请求广告
     */
    @CrossOrigin
    @GetMapping("/getAdvert")
    public Result getAdvert() {
        // 记录广告请求日志
        InnerLogUtils.log(ADVERT_REQUEST, InnerLogUtils.buildJSON());

        System.out.println("deviceId: " + RequestThreadLocal.get().getDeviceId());
        System.out.println("appId: " + RequestThreadLocal.get().getAppId());
        return ResultBuilder.fail("获取广告失败");
    }
}
