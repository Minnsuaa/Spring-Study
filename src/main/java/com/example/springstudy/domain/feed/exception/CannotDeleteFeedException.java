package com.example.springstudy.domain.feed.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class CannotDeleteFeedException extends CustomException {

    public static final CustomException EXCEPTION = new CannotDeleteFeedException();

    private CannotDeleteFeedException() {
        super(ErrorCode.CANNOT_DELETE_FEED);
    }

}