package com.ikyxxs.adengine.controller;

import com.ikyxxs.adengine.domain.RequestThreadLocal;
import com.ikyxxs.adengine.domain.Result;
import com.ikyxxs.adengine.domain.ResultBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 广告投放接口
 *
 * @author 木白
 * @date 2022/05/11
 */
@RestController
public class AdvertEngineController {

    @CrossOrigin
    @GetMapping("/getAdvert")
    public Result getAdvert() {
        System.out.println("deviceId: " + RequestThreadLocal.get().getDeviceId());
        System.out.println("appId: " + RequestThreadLocal.get().getAppId());
        return ResultBuilder.fail("获取广告失败");
    }
}
