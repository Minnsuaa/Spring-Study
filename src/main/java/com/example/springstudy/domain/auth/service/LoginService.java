package com.example.springstudy.domain.auth.service;

import com.example.springstudy.domain.auth.exception.PasswordMisMatchException;
import com.example.springstudy.domain.auth.presentation.dto.request.AuthRequest;
import com.example.springstudy.domain.auth.presentation.dto.response.TokenResponse;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.domain.repository.UserRepository;
import com.example.springstudy.domain.user.exception.UserNotFoundException;
import com.example.springstudy.global.security.jwt.JwtProperties;
import com.example.springstudy.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional(readOnly = true)
    public TokenResponse login(AuthRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());
        ZonedDateTime accessExpiredAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusSeconds(jwtProperties.getAccessExp());
        ZonedDateTime refreshExpiredAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusSeconds(jwtProperties.getRefreshExp());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .accessExpiredAt(accessExpiredAt)
                .refreshToken(refreshToken)
                .refreshExpiredAt(refreshExpiredAt)
                .build();
    }

}