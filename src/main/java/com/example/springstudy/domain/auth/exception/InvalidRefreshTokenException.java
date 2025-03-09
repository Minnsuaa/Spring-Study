package com.example.springstudy.domain.auth.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }

}