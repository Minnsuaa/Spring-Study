package com.example.springstudy.domain.comment.presentation;

import com.example.springstudy.domain.comment.presentation.dto.request.CommentRequest;
import com.example.springstudy.domain.comment.presentation.dto.response.CommentResponse;
import com.example.springstudy.domain.comment.service.CreateCommentService;
import com.example.springstudy.domain.comment.service.DeleteCommentService;
import com.example.springstudy.domain.comment.service.QueryCommentsService;
import com.example.springstudy.domain.comment.service.UpdateCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final UpdateCommentService updateCommentService;
    private final QueryCommentsService queryCommentsService;

    @PostMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable("feed-id") Long feedId, @RequestBody @Valid CommentRequest request) {
        createCommentService.createComment(feedId, request);
    }

    @DeleteMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("comment-id") Long commentId) {
        deleteCommentService.deleteComment(commentId);
    }

    @PatchMapping("/{comment-id}")
    public void update(@PathVariable("comment-id") Long commentId ,@RequestBody @Valid CommentRequest request) {
        updateCommentService.updateComment(commentId, request);
    }

    @GetMapping("/{feed-id}")
    public List<CommentResponse> get(@PathVariable("feed-id") Long feedId) {
        return queryCommentsService.getComments(feedId);
    }

}