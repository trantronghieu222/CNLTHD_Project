package com.shop.accountservice.exception;

import java.time.OffsetDateTime;

public enum ErrorCode {
    USER_NOT_FOUND(404, "USER_NOT_FOUND", "Không tìm thấy người dùng."),
    USERNAME_ALREADY_EXISTS(409, "USERNAME_ALREADY_EXISTS", "Tên người dùng đã tồn tại trong hệ thống."),
    ;

    private final int statusCode;
    private final String errorCode;
    private final String message;

    ErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
