package com.example.springstudy.domain.feed.presentation.dto.response;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record FeedResponse(Long feedId, String title, String content, String userName, ZonedDateTime createdAt) {
}