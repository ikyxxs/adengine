package com.ikyxxs.adengine.domain;

import java.io.Serializable;

/**
 * 统一请求返回数据格式
 *
 * @author 木白
 * @date 2022/05/11
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2067113999548125524L;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 状态码
     */
    public Integer code;

    /**
     * 错误信息
     */
    public String msg;

    /**
     * 数据对象
     */
    public T data;

    /**
     * 服务器当前时间戳
     */
    private Long timestamp;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
