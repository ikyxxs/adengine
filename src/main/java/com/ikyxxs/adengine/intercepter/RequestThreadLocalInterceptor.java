package com.ikyxxs.adengine.intercepter;

import cn.hutool.core.util.StrUtil;
import com.ikyxxs.adengine.domain.RequestThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestThreadLocalInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestThreadLocal.clear();
        RequestThreadLocal local = RequestThreadLocal.get();

        local.setRequest(request);
        local.setResponse(response);
        local.setDeviceId(request.getParameter("deviceId"));
        String appId = request.getParameter("appId");
        if (StrUtil.isNumeric(appId)) {
            local.setAppId(Long.valueOf(appId));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        RequestThreadLocal.remove();
    }
}
