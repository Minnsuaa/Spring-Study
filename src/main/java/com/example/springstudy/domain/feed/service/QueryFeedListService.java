package com.example.springstudy.domain.feed.service;

import com.example.springstudy.domain.feed.domain.repository.FeedRepository;
import com.example.springstudy.domain.feed.presentation.dto.response.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryFeedListService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<FeedResponse> getFeedList() {
        return feedRepository.findAll()
                .stream()
                .map(feed -> FeedResponse.builder()
                        .feedId(feed.getId())
                        .title(feed.getTitle())
                        .content(feed.getContent())
                        .userName(feed.getUser().getUserName())
                        .createdAt(feed.getCreatedAt())
                        .build())
                .toList();
    }

}