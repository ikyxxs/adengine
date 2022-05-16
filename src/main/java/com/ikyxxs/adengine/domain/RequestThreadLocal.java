package com.ikyxxs.adengine.domain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestThreadLocal {

    private RequestThreadLocal() {
    }

    private static ThreadLocal<RequestThreadLocal> local = new ThreadLocal<>();

    public static RequestThreadLocal get() {
        RequestThreadLocal rl = local.get();
        if (rl == null) {
            rl = new RequestThreadLocal();
            local.set(rl);
        }
        return rl;
    }

    public static void clear() {
        local.set(null);
    }

    public static void remove() {
        local.remove();
    }

    private HttpServletRequest request;

    private HttpServletResponse response;

    /**
     * 媒体ID
     */
    private Long appId;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * 订单号
     */
    private String orderId;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
