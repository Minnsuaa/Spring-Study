package com.example.springstudy.domain.feed.domain.repository;

import com.example.springstudy.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}