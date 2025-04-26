package com.example.springstudy.domain.auth.service;

import com.example.springstudy.domain.auth.presentation.dto.request.AuthRequest;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.domain.repository.UserRepository;
import com.example.springstudy.domain.user.exception.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(AuthRequest request) {
        if(userRepository.findByAccountId(request.accountId()).isPresent())
            throw UserExistException.EXCEPTION;

        userRepository.save(User.builder()
                .accountId(request.accountId())
                .password(passwordEncoder.encode(request.password()))
                .userName(request.userName())
            .build());
    }

}