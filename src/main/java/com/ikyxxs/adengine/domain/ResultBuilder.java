package com.ikyxxs.adengine.domain;

/**
 * 构建请求返回数据对象工具类
 *
 * @author 木白
 * @date 2022/05/11
 */
public class ResultBuilder {

    /**
     * 默认错误码
     */
    private static final Integer DEFAULT_FAIL_CODE = 500;

    /**
     * 默认成功码
     */
    private static final Integer DEFAULT_SUCCESS_CODE = 200;

    private ResultBuilder() {
    }

    /**
     * 带自定义响应码的描述信息数据对象Result
     *
     * @param code 错误码
     * @param desc 失败描述
     * @return Result
     */
    public static <T> Result<T> fail(Integer code, String desc) {
        Result<T> result = new Result<>();
        result.setTimestamp(System.currentTimeMillis());
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(desc);
        return result;
    }

    /**
     * 使用默认错误码,描述错误信息(统一使用默认错误码)
     *
     * @param desc 失败描述
     * @return Result
     */
    public static <T> Result<T> fail(String desc) {
        return fail(DEFAULT_FAIL_CODE, desc);
    }

    /**
     * 带有数据的失败返回
     *
     * @param code 失败码
     * @param desc 失败信息
     * @param data 数据
     * @return Result
     */
    public static <T> Result<T> fail(Integer code, String desc, T data) {
        Result<T> result = new Result<>();
        result.setTimestamp(System.currentTimeMillis());
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(desc);
        result.setData(data);
        return result;
    }

    /**
     * 带有数据的失败返回,统一使用默认错误码
     *
     * @param desc 失败信息
     * @param data 数据
     * @return Result
     */
    public static <T> Result<T> fail(String desc, T data) {
        return fail(DEFAULT_FAIL_CODE, desc, data);
    }

    /**
     * 使用自定义成功码的成功数据对象构建
     *
     * @param code 成功码
     * @param data 数据
     * @return Result
     */
    public static <T> Result<T> success(Integer code, T data) {
        Result<T> result = new Result<>();
        result.setTimestamp(System.currentTimeMillis());
        result.setSuccess(true);
        result.setCode(code);
        result.setData(data);
        result.setMsg("OK");
        return result;
    }

    /**
     * 统一使用默认成功码的成功数据对象构建
     *
     * @param data 数据
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return success(DEFAULT_SUCCESS_CODE, data);
    }

    /**
     * 成功,不返回任何数据,统一使用默认成功码
     *
     * @return Result
     */
    public static <T> Result<T> success() {
        return success(DEFAULT_SUCCESS_CODE, null);
    }
}
