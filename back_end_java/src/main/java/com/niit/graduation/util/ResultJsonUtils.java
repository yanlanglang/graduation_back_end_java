package com.niit.graduation.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author Yan Lang
 * @Date 2021/3/30
 * explain: 响应Json封装
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ResultJsonUtils {

    // 正确返回代码
    private static final String SUCCESS_CODE = "1";
    // 错误返回代码
    private static final String ERROR_CODE = "-1";

    //状态码
    private static final int CODE_404 = 404;

    private static final int CODE_200 = 200;

    // 状态代码
    private int code;
    // 信息
    private String msg;
    // 内容
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultJsonUtils() {}

    public ResultJsonUtils(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultJsonUtils{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static ResultJsonUtils ok(Object data) {
        return ok("请求成功", data);
    }

    public static ResultJsonUtils ok(String msg, Object data) {
        return new ResultJsonUtils(CODE_200, msg, data);
    }

    public static ResultJsonUtils error(Object data) {
        return error("请求失败", data);
    }

    public static ResultJsonUtils error(String msg, Object data) {
        return new ResultJsonUtils(CODE_404, msg, data);
    }

}
