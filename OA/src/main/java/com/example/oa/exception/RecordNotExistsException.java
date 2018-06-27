package com.example.oa.exception;

public class RecordNotExistsException extends Exception {

    private String redirect;

    public RecordNotExistsException(String message) {
        super(message);
    }

    public RecordNotExistsException(String url, String message) {
        super(message);
        this.redirect = url;
    }

    public String getRedirect() {
        return redirect;
    }
}
