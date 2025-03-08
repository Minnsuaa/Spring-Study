package com.example.springstudy.domain.like.domain.repository;

import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.like.domain.Like;
import com.example.springstudy.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    boolean existsByUserAndFeed(User user, Feed feed);
    void deleteLikeByUserAndFeed(User user, Feed feed);

}