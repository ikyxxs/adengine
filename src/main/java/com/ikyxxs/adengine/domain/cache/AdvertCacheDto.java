package com.ikyxxs.adengine.domain.cache;

import java.util.*;

/**
 * 广告缓存DTO
 *
 * @author 木白
 * @date 2022/05/16
 */
public class AdvertCacheDto {

    /**
     * 广告ID
     */
    private Long advertId;

    /**
     * 广告名称
     */
    private String advertName;

    /**
     * 落地页链接
     */
    private String landpageUrl;

    /**
     * 计费单价(分)
     */
    private Integer unitPrice;

    /**
     * 开始投放日期
     */
    private Date startServingDate;

    /**
     * 结束投放日期
     */
    private Date stopServingDate;

    /**
     * 投放开关:0.关闭,1.开启
     */
    private Integer servingSwitch;

    /**
     * 状态:0.正常,1.无效,2.无效(预算不足)
     */
    private Integer advertStatus;

    /**
     * 可投的素材列表
     */
    private TreeMap<Integer, MaterialCacheDto> materialMap;

    /**
     * 排序因子
     */
    private Integer orderFactor;

    /**
     * 深拷贝
     */
    public AdvertCacheDto copy() {
        AdvertCacheDto copy = new AdvertCacheDto();
        copy.advertId = this.advertId;
        copy.advertName = this.advertName;
        copy.landpageUrl = this.landpageUrl;
        copy.unitPrice = this.unitPrice;
        copy.startServingDate = this.startServingDate;
        copy.stopServingDate = this.stopServingDate;
        copy.servingSwitch = this.servingSwitch;
        copy.advertStatus = this.advertStatus;
        copy.orderFactor = this.orderFactor;
        copy.materialMap = new TreeMap<>();
        if (null != this.materialMap) {
            this.materialMap.forEach((key, value) -> copy.materialMap.put(key, value.copy()));
        }
        return copy;
    }

    /**
     * 根据权重随机获取素材
     */
    public MaterialCacheDto randomMaterial(int shuntHash) {
        if (null == this.materialMap) {
            return null;
        }
        int randomWeight = shuntHash % this.materialMap.lastKey();
        SortedMap<Integer, MaterialCacheDto> tailMap = this.materialMap.tailMap(randomWeight, false);
        return this.materialMap.get(tailMap.firstKey());
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getLandpageUrl() {
        return landpageUrl;
    }

    public void setLandpageUrl(String landpageUrl) {
        this.landpageUrl = landpageUrl;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getStartServingDate() {
        return startServingDate;
    }

    public void setStartServingDate(Date startServingDate) {
        this.startServingDate = startServingDate;
    }

    public Date getStopServingDate() {
        return stopServingDate;
    }

    public void setStopServingDate(Date stopServingDate) {
        this.stopServingDate = stopServingDate;
    }

    public Integer getServingSwitch() {
        return servingSwitch;
    }

    public void setServingSwitch(Integer servingSwitch) {
        this.servingSwitch = servingSwitch;
    }

    public Integer getAdvertStatus() {
        return advertStatus;
    }

    public void setAdvertStatus(Integer advertStatus) {
        this.advertStatus = advertStatus;
    }

    public TreeMap<Integer, MaterialCacheDto> getMaterialMap() {
        return materialMap;
    }

    public void setMaterialMap(TreeMap<Integer, MaterialCacheDto> materialMap) {
        this.materialMap = materialMap;
    }

    public Integer getOrderFactor() {
        return orderFactor;
    }

    public void setOrderFactor(Integer orderFactor) {
        this.orderFactor = orderFactor;
    }
}
