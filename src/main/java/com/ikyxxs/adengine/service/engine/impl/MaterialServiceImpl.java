package com.ikyxxs.adengine.service.engine.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ikyxxs.adengine.domain.entity.MaterialDO;
import com.ikyxxs.adengine.mapper.MaterialMapper;
import com.ikyxxs.adengine.service.engine.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 素材服务接口实现
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public Map<Long, List<MaterialDO>> selectValidByAdvertIds(List<Long> advertIds) {
        LambdaQueryWrapper<MaterialDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(MaterialDO::getAdvertId, advertIds);
        List<MaterialDO> materials = materialMapper.selectBySql(wrapper);
        return materials.stream().collect(Collectors.groupingBy(MaterialDO::getAdvertId));
    }
}
