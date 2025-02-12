package com.example.springstudy.domain.comment.presentation;

import com.example.springstudy.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.springstudy.domain.comment.presentation.dto.request.DeleteCommentRequest;
import com.example.springstudy.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.example.springstudy.domain.comment.service.CreateCommentService;
import com.example.springstudy.domain.comment.service.DeleteCommentService;
import com.example.springstudy.domain.comment.service.UpdateCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final UpdateCommentService updateCommentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateCommentRequest request) {
        createCommentService.createComment(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody @Valid DeleteCommentRequest request) {
        deleteCommentService.deleteComment(request);
    }

    @PatchMapping
    public void update(@RequestBody @Valid UpdateCommentRequest request) {
        updateCommentService.updateComment(request);
    }

}