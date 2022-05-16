package com.ikyxxs.adengine.service.engine;

import com.ikyxxs.adengine.domain.entity.MaterialDO;

import java.util.List;
import java.util.Map;

/**
 * 素材服务接口
 *
 * @author 木白
 * @date 2022/05/16
 */
public interface MaterialService {

    /**
     * 查询广告有效素材
     *
     * @param advertIds 广告位ID列表
     * @return 广告ID-素材列表映射
     */
    Map<Long, List<MaterialDO>> selectValidByAdvertIds(List<Long> advertIds);
}
