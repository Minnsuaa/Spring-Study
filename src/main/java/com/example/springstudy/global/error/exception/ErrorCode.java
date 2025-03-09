package com.example.springstudy.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    // user
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    USER_EXISTS(HttpStatus.CONFLICT, "User Already Exists"),
    PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "Password Mismatch"),

    // jwt
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired JWT"),
    INVALID_JWT(HttpStatus.UNAUTHORIZED, "Invalid JWT"),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid Refresh Token"),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "Refresh token Not Found"),

    // feed
    FEED_NOT_FOUND(HttpStatus.NOT_FOUND, "Feed Not Found"),
    CANNOT_DELETE_FEED(HttpStatus.FORBIDDEN, "Can't Delete Feed"),
    CANNOT_MODIFY_FEED(HttpStatus.FORBIDDEN, "Can't Modify Feed"),

    // comment
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Comment Not Found"),
    CANNOT_DELETE_COMMENT(HttpStatus.FORBIDDEN, "Can't Delete Comment"),
    CANNOT_MODIFY_COMMENT(HttpStatus.FORBIDDEN, "Can't Modify Comment"),

    // like
    LIKE_ALREADY_EXISTS(HttpStatus.CONFLICT, "Like Already Exists"),
    LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, "Like Not Found");

    private final HttpStatus status;
    private final String message;

}