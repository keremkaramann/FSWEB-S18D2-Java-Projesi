package com.example.s13d2.s13practice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends RuntimeException {
    private HttpStatus status;

    public GeneralException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
