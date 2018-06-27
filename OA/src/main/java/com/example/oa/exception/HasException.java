package com.example.oa.exception;

import org.springframework.http.HttpStatus;

public class HasException extends Exception {

    private HttpStatus httpStatus;

    private Integer code;

    public HasException(String msg) {
        super(msg);
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        this.code = 422;
    }

    public HasException(String msg, HttpStatus httpStatus, Integer code) {
        super(msg);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Integer getCode() {
        return code;
    }
}
