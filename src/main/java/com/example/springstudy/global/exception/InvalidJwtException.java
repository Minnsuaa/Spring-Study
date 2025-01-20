package com.example.springstudy.global.exception;

import com.example.springstudy.global.error.CustomException;
import com.example.springstudy.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }

}
