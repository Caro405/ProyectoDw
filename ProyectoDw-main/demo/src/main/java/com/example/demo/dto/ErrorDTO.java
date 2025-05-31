package com.example.demo.dto;

public class ErrorDTO {
    private String errorString;

    public ErrorDTO() {} // Constructor vacío necesario
    
    public ErrorDTO(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}