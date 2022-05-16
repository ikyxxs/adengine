package com.ikyxxs.adengine.service.engine;

import com.ikyxxs.adengine.domain.vo.AdvertVO;

/**
 * 广告引擎接口
 *
 * @author 木白
 * @date 2022/05/16
 */
public interface AdvertEngineService {

    /**
     * 请求广告
     *
     * @return 广告结果
     */
    AdvertVO getAdvert();
}
