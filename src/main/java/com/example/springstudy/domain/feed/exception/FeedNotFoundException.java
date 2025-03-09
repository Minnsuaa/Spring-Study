package com.example.springstudy.domain.feed.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class FeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }

}