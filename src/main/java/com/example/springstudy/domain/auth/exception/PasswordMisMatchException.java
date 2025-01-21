package com.example.springstudy.domain.auth.exception;

import com.example.springstudy.global.error.CustomException;
import com.example.springstudy.global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final CustomException EXCEPTION = new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}