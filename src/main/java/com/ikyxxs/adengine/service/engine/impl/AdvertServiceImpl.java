package com.ikyxxs.adengine.service.engine.impl;

import com.ikyxxs.adengine.domain.entity.AdvertDO;
import com.ikyxxs.adengine.service.engine.AdvertService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 广告服务接口实现
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class AdvertServiceImpl implements AdvertService {

    @Override
    public List<AdvertDO> selectValidAdverts() {
        return Collections.emptyList();
    }

    @Override
    public AdvertDO selectAdvertById(Long advertId) {
        return null;
    }
}
