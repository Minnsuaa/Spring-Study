package com.example.springstudy.domain.comment.service;

import com.example.springstudy.domain.comment.domain.repository.CommentRepository;
import com.example.springstudy.domain.comment.presentation.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCommentsService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<CommentResponse> getComments(Long feedId) {
        return commentRepository.findByFeedId(feedId)
                .stream()
                .map(comment -> CommentResponse.builder()
                        .commentId(comment.getId())
                        .comment(comment.getComment())
                        .userName(comment.getUser().getUserName())
                        .createdAt(comment.getCreatedAt())
                        .build())
                .toList();
    }

}