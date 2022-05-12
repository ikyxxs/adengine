package com.ikyxxs.adengine.enums;

/**
 * 业务日志类型枚举
 *
 * @author 木白
 * @date 2022/05/12
 */
public enum InnerLogType {

    ADVERT_REQUEST(1, "广告请求"),
    ;

    private final int type;
    private final String desc;

    InnerLogType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
