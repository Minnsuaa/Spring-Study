package com.example.springstudy.domain.auth.presentation;

import com.example.springstudy.domain.auth.presentation.dto.request.AuthRequest;
import com.example.springstudy.domain.auth.presentation.dto.response.TokenResponse;
import com.example.springstudy.domain.auth.service.LoginService;
import com.example.springstudy.domain.auth.service.LogoutService;
import com.example.springstudy.domain.auth.service.ReissueService;
import com.example.springstudy.domain.auth.service.SignupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final ReissueService reissueService;
    private final LogoutService logoutService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid AuthRequest request) {
        signupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AuthRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(HttpServletRequest request) {
        return reissueService.reissue(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout() {
        logoutService.logout();
    }

}