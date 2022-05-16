package com.ikyxxs.adengine.service.filter;

import com.ikyxxs.adengine.domain.AdvertFilterContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * 广告过滤处理器
 *
 * @author 木白
 * @date 2022/05/16
 */
@Service
public class AdvertFilterHandler {

    /**
     * 广告过滤链
     */
    private final List<AdvertFilter> filterChain;

    @Autowired
    public AdvertFilterHandler(List<AdvertFilter> advertFilters) {
        this.filterChain = advertFilters;
        this.filterChain.sort(Comparator.comparingInt(AdvertFilter::getOrder));
    }

    /**
     * 执行过滤逻辑
     */
    public boolean doFilter(final AdvertFilterContext context) {
        for (AdvertFilter filter : filterChain) {
            boolean result = filter.validate(context) && filter.filter(context);
            filter.afterFiler(result, context);
            if (!result) {
                return false;
            }
        }
        return true;
    }
}
