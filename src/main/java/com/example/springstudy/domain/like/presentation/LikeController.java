package com.example.springstudy.domain.like.presentation;

import com.example.springstudy.domain.like.service.LikeService;
import com.example.springstudy.domain.like.service.UnLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    private final UnLikeService unLikeService;

    @PostMapping("/{feed-id}")
    public void like(@PathVariable("feed-id") Long feedId) {
        likeService.execute(feedId);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unLike(@PathVariable("feed-id") Long feedId) {
        unLikeService.execute(feedId);
    }

}