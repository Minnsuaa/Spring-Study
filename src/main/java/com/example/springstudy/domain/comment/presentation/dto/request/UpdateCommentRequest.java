package com.example.springstudy.domain.comment.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateCommentRequest {

    @NotBlank
    @Size(max = 100)
    private String comment;

    @NotNull
    private Long feedId;

    @NotNull
    private Long commentId;

}