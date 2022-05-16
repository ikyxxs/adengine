package com.ikyxxs.adengine.domain;

import cn.hutool.core.date.DateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 广告过滤原因
 *
 * @author 木白
 * @date 2022/05/16
 */
public class AdvertFilterReason implements Serializable {
    private static final long serialVersionUID = 6604910585198883542L;

    /**
     * 时间
     */
    private String time;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * 媒体ID
     */
    private Long appId;

    /**
     * 备选广告总数
     */
    private Integer total;

    /**
     * 配置ID-过滤原因映射
     */
    private Map<Long, String> reasons;

    /**
     * 构造过滤原因对象
     */
    public static AdvertFilterReason build(RequestThreadLocal local) {
        AdvertFilterReason filterReason = new AdvertFilterReason();
        filterReason.setTime(DateUtil.now());
        filterReason.setOrderId(local.getOrderId());
        filterReason.setDeviceId(local.getDeviceId());
        filterReason.setAppId(local.getAppId());
        filterReason.setReasons(new HashMap<>());
        return filterReason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<Long, String> getReasons() {
        return reasons;
    }

    public void setReasons(Map<Long, String> reasons) {
        this.reasons = reasons;
    }
}
