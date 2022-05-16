package com.ikyxxs.adengine.enums;

import java.util.Objects;

/**
 * 开关枚举
 *
 * @author 木白
 * @date 2022/05/16
 */
public enum SwitchStatusEnum {

    OFF(0, "关闭"),
    ON(1, "开启");

    private final int status;
    private final String desc;

    /**
     * 判断是否是有效的状态
     *
     * @param status 开关状态
     * @return 是否有效
     */
    public static boolean isValidStatus(Integer status) {
        return Objects.equals(status, ON.status) || Objects.equals(status, OFF.status);
    }

    /**
     * 判断开关是否开启
     *
     * @param status 开关状态
     * @return 开关是否开启
     */
    public static boolean isSwitchOn(Integer status) {
        return Objects.equals(status, ON.status);
    }

    /**
     * 判断开关是否关闭
     *
     * @param status 开关状态
     * @return 开关是否关闭
     */
    public static boolean isSwitchOff(Integer status) {
        return Objects.equals(status, OFF.status);
    }

    /**
     * 切换开关状态
     *
     * @param status 开关状态
     * @return 切换后的开关状态
     */
    public static Integer toggle(Integer status) {
        return Objects.equals(status, ON.status) ? OFF.status : ON.status;
    }

    SwitchStatusEnum(int status, String desc) {
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
