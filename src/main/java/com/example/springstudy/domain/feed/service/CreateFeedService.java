package com.example.springstudy.domain.feed.service;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.domain.repository.FeedRepository;
import com.example.springstudy.domain.feed.presentation.dto.request.FeedRequest;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createFeed(FeedRequest request) {
        User user = userFacade.getCurrentUser();

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .build());
    }

}