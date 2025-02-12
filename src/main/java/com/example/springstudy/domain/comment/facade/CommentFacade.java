package com.example.springstudy.domain.comment.facade;

import com.example.springstudy.domain.comment.domain.Comment;
import com.example.springstudy.domain.comment.domain.repository.CommentRepository;
import com.example.springstudy.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

}