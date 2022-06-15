package com.ikyxxs.adengine.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 广告DO
 *
 * @author 木白
 * @date 2022/05/16
 */
@TableName(value = "tb_advert")
public class AdvertDO {

    /**
     * 广告ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 广告名称
     */
    @TableField(value = "advert_name")
    private String advertName;

    /**
     * 计费单价(分)
     */
    @TableField(value = "unit_price")
    private Integer unitPrice;

    /**
     * 开始投放日期
     */
    @TableField(value = "start_serving_date")
    private Date startServingDate;

    /**
     * 结束投放日期
     */
    @TableField(value = "stop_serving_date")
    private Date stopServingDate;

    /**
     * 投放开关:0.关闭,1.开启
     */
    @TableField(value = "serving_switch")
    private Integer servingSwitch;

    /**
     * 状态:0.正常,1.无效
     */
    @TableField(value = "advert_status")
    private Integer advertStatus;

    /**
     * 落地页链接
     */
    @TableField(value = "landpage_url")
    private String landpageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getLandpageUrl() {
        return landpageUrl;
    }

    public void setLandpageUrl(String landpageUrl) {
        this.landpageUrl = landpageUrl;
    }
}
