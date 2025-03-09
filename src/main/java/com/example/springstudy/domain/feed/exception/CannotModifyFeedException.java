package com.example.springstudy.domain.feed.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class CannotModifyFeedException extends CustomException {

    public static final CustomException EXCEPTION = new CannotModifyFeedException();

    private CannotModifyFeedException() {
        super(ErrorCode.CANNOT_MODIFY_FEED);
    }

}