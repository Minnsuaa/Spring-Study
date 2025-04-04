package com.example.springstudy.domain.like.service;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.facade.FeedFacade;
import com.example.springstudy.domain.like.domain.repository.LikeRepository;
import com.example.springstudy.domain.like.exception.LikeNotFoundException;
import com.example.springstudy.domain.like.facade.LikeFacade;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UnLikeService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final LikeFacade likeFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public void execute(Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (!likeFacade.checkLike(user, feed)) {
            throw LikeNotFoundException.EXCEPTION;
        }

        likeRepository.deleteLikeByUserAndFeed(user, feed);
        feed.minusLike();
    }

}