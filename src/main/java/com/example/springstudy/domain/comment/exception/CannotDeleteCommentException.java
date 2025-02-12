package com.example.springstudy.domain.comment.exception;

import com.example.springstudy.global.error.CustomException;
import com.example.springstudy.global.error.ErrorCode;

public class CannotDeleteCommentException extends CustomException {

    public static final CustomException EXCEPTION = new CannotDeleteCommentException();

    private CannotDeleteCommentException() {
        super(ErrorCode.CANNOT_DELETE_COMMENT);
    }

}