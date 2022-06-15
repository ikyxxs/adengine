package com.ikyxxs.adengine.service.engine.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ikyxxs.adengine.domain.entity.AdvertDO;
import com.ikyxxs.adengine.mapper.AdvertMapper;
import com.ikyxxs.adengine.service.engine.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 广告服务接口实现
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertMapper advertMapper;

    @Override
    public List<AdvertDO> selectValidAdverts() {
        Date today = DateUtil.beginOfDay(new Date());
        LambdaQueryWrapper<AdvertDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdvertDO::getServingSwitch, 1)
                .eq(AdvertDO::getAdvertStatus, 0)
                .le(AdvertDO::getStartServingDate, today)
                .ge(AdvertDO::getStopServingDate, today);
        return advertMapper.selectBySql(wrapper);
    }

    @Override
    public AdvertDO selectAdvertById(Long advertId) {
        return advertMapper.selectById(advertId);
    }
}
