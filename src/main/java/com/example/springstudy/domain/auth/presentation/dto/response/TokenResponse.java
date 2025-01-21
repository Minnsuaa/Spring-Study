package com.example.springstudy.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class TokenResponse {

    private final String accessToken;
    private final ZonedDateTime accessExpiredAt;
    private final String refreshToken;
    private final ZonedDateTime refreshExpiredAt;

}