package com.ikyxxs.adengine.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 素材DO
 *
 * @author 木白
 * @date 2022/05/16
 */
@TableName(value = "tb_material")
public class MaterialDO {

    /**
     * 素材ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 广告ID
     */
    @TableField(value = "advert_id")
    private Long advertId;

    /**
     * 权重
     */
    @TableField(value = "weight")
    private Integer weight;

    /**
     * 广告标题
     */
    @TableField(value = "advert_title")
    private String advertTitle;

    /**
     * 按钮文案
     */
    @TableField(value = "button_text")
    private String buttonText;

    /**
     * 素材图链接
     */
    @TableField(value = "material_img")
    private String materialImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
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
