package com.example.usermanagement.exceptions;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

//@Data
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, LocalDateTime timestamp){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // getter and setter
    // Add getters
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Add setters if needed
    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
