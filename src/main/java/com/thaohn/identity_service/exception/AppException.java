package com.thaohn.identity_service.exception;

public class AppException extends RuntimeException{
    public AppException(ErrorCode errorCode) {
      super(errorCode.getMessage());  //   ke thua
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
