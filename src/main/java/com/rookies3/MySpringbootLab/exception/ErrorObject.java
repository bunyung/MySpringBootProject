package com.rookies3.MySpringbootLab.exception;

import java.time.LocalDateTime;

public class ErrorObject {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    public ErrorObject(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
