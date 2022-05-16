package com.ikyxxs.adengine.service.engine.impl;

import com.ikyxxs.adengine.domain.entity.MaterialDO;
import com.ikyxxs.adengine.service.engine.MaterialService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 素材服务接口实现
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Override
    public Map<Long, List<MaterialDO>> selectValidByAdvertIds(List<Long> advertIds) {
        return Collections.emptyMap();
    }
}
