package com.ikyxxs.adengine.service.engine;

import com.ikyxxs.adengine.domain.entity.AdvertDO;

import java.util.List;

/**
 * 广告服务接口
 *
 * @author 木白
 * @date 2022/05/16
 */
public interface AdvertService {

    /**
     * 查询有效广告列表
     *
     * @return 广告列表
     */
    List<AdvertDO> selectValidAdverts();

    /**
     * 查询广告信息
     *
     * @param advertId 广告Id
     * @return 广告信息
     */
    AdvertDO selectAdvertById(Long advertId);
}
