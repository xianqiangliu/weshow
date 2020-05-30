package com.jianzhonglang.weshow.common;


import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 *  响应结果类
 * </p>
 *
 * @author xianqiangliu
 * @since 2020-05-30
 */
@Data
public class Result implements Serializable {
    private int code;

    private String msg;

    private Object data;

    public static Result success(int code, String msg, Object data) {
        return setResult(code, msg, data);
    }

    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }

    public static Result fail(int code, String msg, Object data) {
        return setResult(code, msg, data);
    }

    public static Result fail(int code, String msg) {
        return setResult(code, msg, null);
    }

    public static Result fail(int code) {
        return setResult(code, "操作失败", null);
    }

    private static Result setResult(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
