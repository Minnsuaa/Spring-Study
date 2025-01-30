package com.example.springstudy.domain.feed.service;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.facade.FeedFacade;
import com.example.springstudy.domain.feed.presentation.dto.response.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryFeedService {

    private final FeedFacade feedFacade;

    @Transactional(readOnly = true)
    public FeedResponse getFeed(Long feedId) {
        Feed feed = feedFacade.getFeed(feedId);

        return FeedResponse.builder()
                .feedId(feedId)
                .title(feed.getTitle())
                .content(feed.getContent())
                .userName(feed.getUser().getUserName())
                .createdAt(feed.getCreatedAt())
                .build();
    }

}