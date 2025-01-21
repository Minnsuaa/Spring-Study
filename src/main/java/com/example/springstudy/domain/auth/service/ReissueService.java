package com.example.springstudy.domain.auth.service;

import com.example.springstudy.domain.auth.domain.RefreshToken;
import com.example.springstudy.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.springstudy.domain.auth.exception.InvalidRefreshTokenException;
import com.example.springstudy.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.springstudy.domain.auth.presentation.dto.response.TokenResponse;
import com.example.springstudy.global.security.jwt.JwtProperties;
import com.example.springstudy.global.security.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse reissue(HttpServletRequest request) {
        String refreshToken = request.getHeader("Authorization");
        String parseToken = jwtTokenProvider.parseToken(refreshToken);

        if (parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByRefreshToken(parseToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getAccountId());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String newAccessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getAccountId());
        ZonedDateTime accessExpiredAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusSeconds(jwtProperties.getAccessExp());
        ZonedDateTime refreshExpiredAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusSeconds(jwtProperties.getRefreshExp());

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .accessExpiredAt(accessExpiredAt)
                .refreshToken(newRefreshToken)
                .refreshExpiredAt(refreshExpiredAt)
                .build();
    }

}