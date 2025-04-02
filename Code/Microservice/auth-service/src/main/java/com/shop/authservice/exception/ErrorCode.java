package com.shop.authservice.exception;

public enum ErrorCode {
    INVALID_CREDENTIALS(401, "INVALID_CREDENTIALS", "Mật khẩu không chính xác!"),
    JWT_TOKEN_CREATION_FAILED(500, "JWT_TOKEN_CREATION_FAILED", "Lỗi khi tạo JWT token!"),
    INVALID_JWT_TOKEN(401, "INVALID_JWT_TOKEN", "Token JWT không hợp lệ!"),
    ;

    private final int statusCode;
    private final String errorCode;
    private final String message;// Thêm timestamp

    ErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;// Gán timestamp khi tạo lỗi
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
