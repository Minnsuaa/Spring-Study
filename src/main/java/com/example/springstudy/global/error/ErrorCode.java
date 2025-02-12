package com.example.springstudy.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    // user
    USER_NOT_FOUND(404, "User Not Found"),
    USER_EXISTS(409, "User Already Exists"),
    PASSWORD_MISMATCH(400, "Password Mismatch"),

    // jwt
    EXPIRED_JWT(401, "Expired JWT"),
    INVALID_JWT(401, "Invalid JWT"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh token Not Found"),

    // feed
    FEED_NOT_FOUND(404, "Feed Not Found"),
    CANNOT_DELETE_FEED(403, "Can't Delete Feed"),
    CANNOT_MODIFY_FEED(403, "Can't Modify Feed"),

    // comment
    COMMENT_NOT_FOUND(404, "Comment Not Found"),
    CANNOT_DELETE_COMMENT(403, "Can't Delete Comment"),
    CANNOT_MODIFY_COMMENT(403, "Can't Modify Comment");

    private final int status;
    private final String message;

}