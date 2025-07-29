package com.example.pos.handler;

public class AppException extends RuntimeException{
    private int code;
    private String error;

    public AppException(String error){
        super(error);
        this.error = error;
    }

    public AppException(String error, int code) {
        this.error = error;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
