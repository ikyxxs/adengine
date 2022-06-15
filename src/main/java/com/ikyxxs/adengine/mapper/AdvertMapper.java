package com.ikyxxs.adengine.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ikyxxs.adengine.domain.entity.AdvertDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertMapper extends BaseMapper<AdvertDO> {

    @Select("select * from tb_advert ${ew.customSqlSegment}")
    List<AdvertDO> selectBySql(@Param(Constants.WRAPPER) Wrapper<AdvertDO> wrapper);
}
