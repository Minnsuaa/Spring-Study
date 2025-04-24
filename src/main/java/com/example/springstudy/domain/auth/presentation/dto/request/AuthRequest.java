package com.example.springstudy.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(

    @NotBlank
    @Size(min = 8, max = 20)
    String accountId,

    @NotBlank
    @Size(min = 8, max = 20)
    String password,

    @Size(min = 3, max = 10)
    String userName

) {
}