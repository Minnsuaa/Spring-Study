package com.example.springstudy.domain.like.facade;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.like.domain.repository.LikeRepository;
import com.example.springstudy.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeFacade {

    private final LikeRepository likeRepository;

    public boolean checkLike(User user, Feed feed) {
        return likeRepository.existsByUserAndFeed(user, feed);
    }

}