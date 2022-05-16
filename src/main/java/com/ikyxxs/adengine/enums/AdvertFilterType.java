package com.ikyxxs.adengine.enums;

/**
 * 广告过滤类型枚举
 *
 * @author 木白
 * @date 2022/05/16
 */
public enum AdvertFilterType {

    // 广告过滤
    ADVERT_STATUS("1.1", "广告状态", 1),
    SERVING_SWITCH("1.2", "广告开关", 2),
    SERVING_DATE("1.3", "广告投放周期", 3),
    ;

    private final String code;
    private final String desc;
    private final int order;

    AdvertFilterType(String code, String desc, int order) {
        this.code = code;
        this.desc = desc;
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public int getOrder() {
        return order;
    }
}
