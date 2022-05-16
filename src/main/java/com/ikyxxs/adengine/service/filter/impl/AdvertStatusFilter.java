package com.ikyxxs.adengine.service.filter.impl;

import com.ikyxxs.adengine.domain.AdvertFilterContext;
import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;
import com.ikyxxs.adengine.enums.AdvertFilterType;
import com.ikyxxs.adengine.service.filter.AdvertFilter;
import org.springframework.stereotype.Component;

import static com.ikyxxs.adengine.enums.AdvertStatusEnum.isAdvertValid;

/**
 * 广告状态过滤
 */
@Component
public class AdvertStatusFilter implements AdvertFilter {

    @Override
    public boolean filter(AdvertFilterContext context) {
        AdvertCacheDto ad = context.getAdvertCacheDto();
        return isAdvertValid(ad.getAdvertStatus());
    }

    @Override
    public AdvertFilterType getType() {
        return AdvertFilterType.ADVERT_STATUS;
    }
}
