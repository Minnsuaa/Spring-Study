package com.example.springstudy.domain.comment.exception;

import com.example.springstudy.global.error.exception.CustomException;
import com.example.springstudy.global.error.exception.ErrorCode;

public class CannotModifyCommentException extends CustomException {

    public static final CustomException EXCEPTION = new CannotModifyCommentException();

    private CannotModifyCommentException() {
        super(ErrorCode.CANNOT_MODIFY_COMMENT);
    }

}