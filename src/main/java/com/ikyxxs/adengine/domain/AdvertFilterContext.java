package com.ikyxxs.adengine.domain;

import com.ikyxxs.adengine.domain.cache.AdvertCacheDto;

import java.util.Date;
import java.util.Set;

/**
 * 广告过滤上下文
 *
 * @author 木白
 * @date 2022/05/16
 */
public class AdvertFilterContext {

    /**
     * 今日日期
     */
    private Date today;

    /**
     * 媒体ID
     */
    private Long appId;

    /**
     * 广告缓存
     */
    private AdvertCacheDto advertCacheDto;

    /**
     * 重复曝光的广告ID集合
     */
    private Set<Long> repeatAdvertIds;

    /**
     * 过滤原因
     */
    private AdvertFilterReason filterReason;

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public AdvertCacheDto getAdvertCacheDto() {
        return advertCacheDto;
    }

    public void setAdvertCacheDto(AdvertCacheDto advertCacheDto) {
        this.advertCacheDto = advertCacheDto;
    }

    public Set<Long> getRepeatAdvertIds() {
        return repeatAdvertIds;
    }

    public void setRepeatAdvertIds(Set<Long> repeatAdvertIds) {
        this.repeatAdvertIds = repeatAdvertIds;
    }

    public AdvertFilterReason getFilterReason() {
        return filterReason;
    }

    public void setFilterReason(AdvertFilterReason filterReason) {
        this.filterReason = filterReason;
    }
}
