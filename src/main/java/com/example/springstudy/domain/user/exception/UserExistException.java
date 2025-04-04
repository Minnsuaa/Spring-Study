package com.example.springstudy.domain.user.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class UserExistException extends CustomException {

    public static final CustomException EXCEPTION = new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXISTS);
    }

}