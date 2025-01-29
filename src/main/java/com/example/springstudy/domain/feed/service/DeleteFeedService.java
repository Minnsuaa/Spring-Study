package com.example.springstudy.domain.feed.service;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.domain.repository.FeedRepository;
import com.example.springstudy.domain.feed.exception.CannotDeleteFeedException;
import com.example.springstudy.domain.feed.facade.FeedFacade;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void deleteFeed(Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if(!user.equals(feed.getUser()))
            throw CannotDeleteFeedException.EXCEPTION;

        feedRepository.delete(feed);
    }

}