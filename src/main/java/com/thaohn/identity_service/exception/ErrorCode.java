package com.thaohn.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1002,"User existed" ),
    USER_NOT_EXISTED(1005,"User not existed" ),
    INVALID_KEY(1001,"Invalid message key" ),
    UNCATEGORIED_EXCEPTION(999,"uncategoried"),
    USERNAME_INVALIED(1003,"Username must be at least 3 characters")

    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
