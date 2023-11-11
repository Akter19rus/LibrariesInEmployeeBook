package com.example.StreamAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidInput extends RuntimeException {
    public EmployeeInvalidInput(String message) {
        super(message);
    }
}
