package com.example.s13d2.s13practice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GeneralErrorResponse {
private int status;
private String message;
private LocalDateTime dateTime;
}
