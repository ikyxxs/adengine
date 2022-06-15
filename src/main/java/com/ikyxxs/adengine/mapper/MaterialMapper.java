package com.ikyxxs.adengine.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ikyxxs.adengine.domain.entity.MaterialDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper extends BaseMapper<MaterialDO> {

    @Select("select * from tb_material ${ew.customSqlSegment}")
    List<MaterialDO> selectBySql(@Param(Constants.WRAPPER) Wrapper<MaterialDO> wrapper);
}
