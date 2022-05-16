package com.ikyxxs.adengine.domain.vo;

import java.io.Serializable;

/**
 * 广告VO
 *
 * @author 木白
 * @date 2022/05/16
 */
public class AdvertVO implements Serializable {
    private static final long serialVersionUID = 7919428387114535148L;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 广告ID
     */
    private Long advertId;

    /**
     * 广告标题
     */
    private String advertTitle;

    /**
     * 素材图链接
     */
    private String materialImg;

    /**
     * 落地页链接
     */
    private String landpageUrl;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public String getAdvertTitle() {
        return advertTitle;
    }

    public void setAdvertTitle(String advertTitle) {
        this.advertTitle = advertTitle;
    }

    public String getMaterialImg() {
        return materialImg;
    }

    public void setMaterialImg(String materialImg) {
        this.materialImg = materialImg;
    }

    public String getLandpageUrl() {
        return landpageUrl;
    }

    public void setLandpageUrl(String landpageUrl) {
        this.landpageUrl = landpageUrl;
    }
}
