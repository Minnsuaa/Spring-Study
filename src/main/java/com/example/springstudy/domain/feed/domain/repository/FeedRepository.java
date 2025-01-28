package com.example.springstudy.domain.feed.domain.repository;

import com.example.springstudy.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, Long> {
}
