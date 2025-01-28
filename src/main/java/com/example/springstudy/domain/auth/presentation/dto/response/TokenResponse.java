package com.example.springstudy.domain.auth.presentation.dto.response;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record TokenResponse(String accessToken, ZonedDateTime accessExpiredAt,
                            String refreshToken, ZonedDateTime refreshExpiredAt) {
}