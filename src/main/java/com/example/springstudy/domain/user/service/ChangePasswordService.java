package com.example.springstudy.domain.user.service;

import com.example.springstudy.domain.auth.exception.PasswordMisMatchException;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import com.example.springstudy.domain.user.presentation.dto.request.PasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void changePassword(PasswordRequest request) {
        User user = userFacade.getCurrentUser();

        if(!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        user.changePassword(passwordEncoder.encode(request.getNewPassword()));
    }

}
