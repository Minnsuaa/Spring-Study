package com.example.springstudy.global.error;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;
import com.example.springstudy.global.error.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandling(CustomException e) {
        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(
                ErrorResponse.builder()
                    .status(errorCode.getStatus())
                    .message(errorCode.getMessage())
                    .build(),
                HttpStatus.valueOf(errorCode.getStatus().value())
        );
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindExceptionHandling(BindException e) {
        Map<String, String> errorList = new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

}