package com.ikyxxs.adengine.service.filter.impl;

import com.ikyxxs.adengine.domain.AdvertFilterContext;
import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;
import com.ikyxxs.adengine.enums.AdvertFilterType;
import com.ikyxxs.adengine.service.filter.AdvertFilter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 广告投放周期过滤
 */
@Component
public class AdvertServingDateFilter implements AdvertFilter {

    @Override
    public boolean filter(AdvertFilterContext context) {
        AdvertCacheDto ad = context.getAdvertCacheDto();
        Date today = context.getToday();
        return !today.before(ad.getStartServingDate()) && !today.after(ad.getStopServingDate());
    }

    @Override
    public AdvertFilterType getType() {
        return AdvertFilterType.SERVING_DATE;
    }
}
