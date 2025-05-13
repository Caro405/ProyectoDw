package com.example.demo.dto;

import com.example.demo.dto.ErrorDTO;

public class ErrorDTO {
    private String errorString;

    public ErrorDTO(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
