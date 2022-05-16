package com.ikyxxs.adengine.domain.cache;

/**
 * 素材缓存DTO
 *
 * @author 木白
 * @date 2022/05/16
 */
public class MaterialCacheDto {

    /**
     * 素材ID
     */
    private Long materialId;

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

    /**
     * 深拷贝
     */
    public MaterialCacheDto copy() {
        MaterialCacheDto copy = new MaterialCacheDto();
        copy.materialId = this.materialId;
        copy.weight = this.weight;
        copy.advertTitle = this.advertTitle;
        copy.buttonText = this.buttonText;
        copy.materialImg = this.materialImg;
        return copy;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
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
