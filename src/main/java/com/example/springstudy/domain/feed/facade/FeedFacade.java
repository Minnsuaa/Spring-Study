package com.example.springstudy.domain.feed.facade;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.domain.repository.FeedRepository;
import com.example.springstudy.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeed(Long feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

}