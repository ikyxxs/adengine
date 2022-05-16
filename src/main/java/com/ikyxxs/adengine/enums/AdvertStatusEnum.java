package com.ikyxxs.adengine.enums;

import java.util.Objects;

/**
 * 广告状态枚举
 *
 * @author 木白
 * @date 2022/05/16
 */
public enum AdvertStatusEnum {

    NORMAL(0, "正常"),
    INVALID(1, "无效"),
    ;

    private final int status;
    private final String desc;

    /**
     * 判断广告是否是有效的状态
     *
     * @param status 广告状态
     * @return 是否有效
     */
    public static boolean isAdvertValid(Integer status) {
        return Objects.equals(status, NORMAL.status);
    }

    /**
     * 根据状态获取状态描述
     *
     * @param status 状态
     * @return 状态描述
     */
    public static String getDescByStatus(Integer status) {
        for (AdvertStatusEnum statusEnum : AdvertStatusEnum.values()) {
            if (Objects.equals(statusEnum.getStatus(), status)) {
                return statusEnum.getDesc();
            }
        }
        return "";
    }

    AdvertStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
