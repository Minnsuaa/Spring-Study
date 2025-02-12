package com.example.springstudy.domain.comment.service;

import com.example.springstudy.domain.comment.domain.Comment;
import com.example.springstudy.domain.comment.domain.repository.CommentRepository;
import com.example.springstudy.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.springstudy.domain.feed.domain.Feed;
import com.example.springstudy.domain.feed.facade.FeedFacade;
import com.example.springstudy.domain.user.domain.User;
import com.example.springstudy.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void createComment(CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(request.getFeedId());

        commentRepository.save(Comment.builder()
                        .comment(request.getComment())
                        .user(user)
                        .feed(feed)
                .build());
    }

}