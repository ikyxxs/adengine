package com.ikyxxs.adengine.utils;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.ikyxxs.adengine.domain.RequestThreadLocal;
import com.ikyxxs.adengine.enums.InnerLogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 业务日志工具类
 *
 * @author 木白
 * @date 2022/05/12
 */
public class InnerLogUtils {

    private static final Logger logger = LoggerFactory.getLogger(InnerLogUtils.class);

    /**
     * 构造日志内容
     */
    public static JSONObject buildJSON() {
        RequestThreadLocal local = RequestThreadLocal.get();

        JSONObject logJson = new JSONObject();
        logJson.put("appId", local.getAppId());
        logJson.put("deviceId", local.getDeviceId());
        return logJson;
    }

    /**
     * 打印日志
     */
    public static void log(InnerLogType logType, JSONObject json) {
        JSONObject jo = new JSONObject();
        jo.put("type", logType.getType());
        jo.put("time", DateUtil.now());
        jo.put("json", json);
        logger.info(jo.toJSONString());
    }
}
