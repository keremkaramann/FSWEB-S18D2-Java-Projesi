package com.example.s13d2.s13practice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GeneralErrorResponse> handleException(GeneralException generalException) {
        GeneralErrorResponse generalErrorResponse = new GeneralErrorResponse(
                generalException.getStatus().value(), generalException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(generalErrorResponse, generalException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception) {
        List errorList = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    log.error(fieldError.getField() + ": " + fieldError.getDefaultMessage());
                    Map<String, String> errors = new HashMap<>();
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }

    @ExceptionHandler
    public ResponseEntity<GeneralErrorResponse> handleException(Exception exception) {
        GeneralErrorResponse generalErrorResponse = new GeneralErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
        log.error("EXCEPTION OCCURED: " + exception.getMessage());
        return new ResponseEntity<>(generalErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
