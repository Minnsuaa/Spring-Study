package com.example.springstudy.domain.comment.service;

import com.example.springstudy.domain.comment.domain.Comment;
import com.example.springstudy.domain.comment.domain.repository.CommentRepository;
import com.example.springstudy.domain.comment.exception.CannotDeleteCommentException;
import com.example.springstudy.domain.comment.facade.CommentFacade;
import com.example.springstudy.domain.comment.presentation.dto.request.DeleteCommentRequest;
import com.example.springstudy.domain.feed.exception.FeedNotFoundException;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void deleteComment(DeleteCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getComment(request.getCommentId());

        if (!request.getFeedId().equals(comment.getFeed().getId())) {
            throw FeedNotFoundException.EXCEPTION;
        }

        if (!user.getId().equals(comment.getUser().getId())) {
            throw CannotDeleteCommentException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }

}