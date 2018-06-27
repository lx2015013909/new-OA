package com.example.oa.util;

public class ResultUtil {
    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.setStatus(200);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }

    public static Result success(String msg) {
        return success(msg, "");
    }

    public static Result success(Object data) {
        return success("", data);
    }

    public static Result success() {
        return success("", "");
    }

    public static Result error(String msg, Integer status) {
        Result result = new Result();
        result.setMsg(msg);
        result.setStatus(status);

        return result;
    }

    public static Result error(String msg) {
        return error(msg, 403);
    }

    public static Result error() {
        return error("", 403);
    }
}
