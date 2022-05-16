package com.ikyxxs.adengine.domain.entity;

import java.io.Serializable;

/**
 * 订单信息快照
 *
 * @author 木白
 * @date 2022/05/16
 */
public class AdSnapshot implements Serializable {
    private static final long serialVersionUID = -1818501622530966502L;

    /**
     * 广告名称
     */
    private String advertName;

    /**
     * 计费单价(分)
     */
    private Integer unitPrice;

    /**
     * 落地页链接
     */
    private String landpageUrl;

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getLandpageUrl() {
        return landpageUrl;
    }

    public void setLandpageUrl(String landpageUrl) {
        this.landpageUrl = landpageUrl;
    }
}
