package com.example.oa.exception;

public class ParameterNotValidException extends Exception {

    public ParameterNotValidException(String msg) {
        super(msg);
    }

    public ParameterNotValidException() {
        super("请求参数错误");
    }
}
