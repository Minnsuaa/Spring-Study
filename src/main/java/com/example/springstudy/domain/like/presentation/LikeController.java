package com.example.springstudy.domain.like.presentation;

import com.example.springstudy.domain.like.service.LikeService;
import com.example.springstudy.domain.like.service.UnlikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    private final UnlikeService unlikeService;

    @PostMapping("/{feed-id}")
    public void like(@PathVariable("feed-id") Long feedId) {
        likeService.execute(feedId);
    }

}