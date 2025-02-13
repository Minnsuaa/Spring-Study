package com.example.springstudy.domain.comment.domain.repository;

import com.example.springstudy.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByFeedId(Long feedId);
}