package com.example.springstudy.domain.comment.presentation.dto.response;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record CommentResponse(Long commentId, String comment, String userName, ZonedDateTime createdAt) {
}