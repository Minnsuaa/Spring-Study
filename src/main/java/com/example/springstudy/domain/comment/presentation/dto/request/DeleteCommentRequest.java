package com.example.springstudy.domain.comment.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeleteCommentRequest {

    @NotNull
    private Long commentId;

    @NotNull
    private Long feedId;

}