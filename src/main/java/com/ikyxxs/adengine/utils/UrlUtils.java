package com.ikyxxs.adengine.utils;

import java.util.Map;

/**
 * Url工具类
 */
public class UrlUtils {

    /**
     * 把Map组装成类似aaa=111&bbb=222的字符串
     */
    public static String buildUrlParams(Map<String, String> params) {
        if (null == params || params.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 往URL后面附加GET参数，参数不UrlEncode
     *
     * @param url    原链接
     * @param params 拼接参数
     * @return url 拼接参数后的链接
     */
    public static String appendParams(String url, Map<String, String> params) {
        if (null == params || params.isEmpty()) {
            return url;
        }

        StringBuilder sb = new StringBuilder(url);
        sb.append(sb.indexOf("?") != -1 ? "&" : "?");
        sb.append(buildUrlParams(params));
        return sb.toString();
    }
}
