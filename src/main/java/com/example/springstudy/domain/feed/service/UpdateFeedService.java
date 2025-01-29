package com.example.springstudy.domain.feed.service;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.exception.CannotModifyFeedException;
import com.example.springstudy.domain.feed.facade.FeedFacade;
import com.example.springstudy.domain.feed.presentation.dto.request.FeedRequest;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateFeedService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    @Transactional
    public void updateFeed(FeedRequest request, Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if(!user.equals(feed.getUser()))
            throw CannotModifyFeedException.EXCEPTION;

        feed.update(request);
    }

}