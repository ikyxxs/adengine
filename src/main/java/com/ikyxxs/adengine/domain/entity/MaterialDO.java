package com.ikyxxs.adengine.domain.entity;

/**
 * 素材DO
 *
 * @author 木白
 * @date 2022/05/16
 */
public class MaterialDO {

    /**
     * 素材ID
     */
    private Long id;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 广告标题
     */
    private String advertTitle;

    /**
     * 按钮文案
     */
    private String buttonText;

    /**
     * 素材图链接
     */
    private String materialImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAdvertTitle() {
        return advertTitle;
    }

    public void setAdvertTitle(String advertTitle) {
        this.advertTitle = advertTitle;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getMaterialImg() {
        return materialImg;
    }

    public void setMaterialImg(String materialImg) {
        this.materialImg = materialImg;
    }
}
