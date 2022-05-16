package com.ikyxxs.adengine.service.filter.impl;

import com.ikyxxs.adengine.domain.AdvertFilterContext;
import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;
import com.ikyxxs.adengine.enums.AdvertFilterType;
import com.ikyxxs.adengine.service.filter.AdvertFilter;
import org.springframework.stereotype.Component;

import static com.ikyxxs.adengine.enums.SwitchStatusEnum.isSwitchOn;

/**
 * 广告开关过滤
 */
@Component
public class ServingSwitchFilter implements AdvertFilter {

    @Override
    public boolean filter(AdvertFilterContext context) {
        AdvertCacheDto ad = context.getAdvertCacheDto();
        return isSwitchOn(ad.getServingSwitch());
    }

    @Override
    public AdvertFilterType getType() {
        return AdvertFilterType.SERVING_SWITCH;
    }
}
