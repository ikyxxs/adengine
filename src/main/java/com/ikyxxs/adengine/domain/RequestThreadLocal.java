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
    private String appId;

    /**
     * 设备号
     */
    private String deviceId;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
