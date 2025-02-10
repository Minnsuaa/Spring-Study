package com.example.springstudy.domain.user.presentation;

import com.example.springstudy.domain.user.presentation.dto.request.PasswordRequest;
import com.example.springstudy.domain.user.service.ChangePasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final ChangePasswordService changePasswordService;

    @PostMapping("/password")
    public void changePassword(@RequestBody @Valid PasswordRequest request) {
        changePasswordService.changePassword(request);
    }

}