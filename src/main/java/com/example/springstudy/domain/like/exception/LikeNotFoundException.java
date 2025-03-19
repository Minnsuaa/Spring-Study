package com.example.springstudy.domain.like.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class LikeNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new LikeNotFoundException();

    private LikeNotFoundException() {
        super(ErrorCode.LIKE_NOT_FOUND);
    }

}