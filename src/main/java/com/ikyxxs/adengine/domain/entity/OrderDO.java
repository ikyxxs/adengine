package com.ikyxxs.adengine.domain.entity;

import java.util.Date;

/**
 * 订单DO
 *
 * @author 木白
 * @date 2022/05/16
 */
public class OrderDO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 媒体ID
     */
    private Long appId;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * 广告ID
     */
    private Long advertId;

    /**
     * 素材ID
     */
    private Long materialId;

    /**
     * 广告信息快照
     */
    private String adSnapshot;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getAdSnapshot() {
        return adSnapshot;
    }

    public void setAdSnapshot(String adSnapshot) {
        this.adSnapshot = adSnapshot;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
