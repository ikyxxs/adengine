package com.ikyxxs.adengine.service.filter;

import com.ikyxxs.adengine.domain.AdvertFilterContext;
import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;
import com.ikyxxs.adengine.enums.AdvertFilterType;

/**
 * 广告过滤接口
 *
 * @author 木白
 * @date 2022/05/16
 */
public interface AdvertFilter {

    /**
     * 参数校验
     *
     * @param context 上下文
     * @return true.校验通过,false.校验不通过
     */
    default boolean validate(AdvertFilterContext context) {
        return true;
    }

    /**
     * 过滤逻辑
     *
     * @param context 上下文
     * @return true.可以投放,false.不投放
     */
    boolean filter(AdvertFilterContext context);

    /**
     * 过滤类型
     */
    AdvertFilterType getType();

    /**
     * 过滤顺序
     */
    default int getOrder() {
        return getType().getOrder();
    }

    /**
     * 过滤后的逻辑
     *
     * @param filterResult 过滤结果
     * @param context 上下文
     */
    default void afterFiler(boolean filterResult, AdvertFilterContext context) {
        // 记录过滤原因
        if (!filterResult) {
            AdvertCacheDto advertCacheDto = context.getAdvertCacheDto();
            context.getFilterReason().getReasons().put(advertCacheDto.getAdvertId(), getType().getCode());
        }
    }
}
