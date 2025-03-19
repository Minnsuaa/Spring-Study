package com.example.springstudy.domain.like.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class LikeAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new LikeAlreadyExistsException();

    private LikeAlreadyExistsException() {
        super(ErrorCode.LIKE_ALREADY_EXISTS);
    }

}