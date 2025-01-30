package com.example.springstudy.domain.feed.presentation;

import com.example.springstudy.domain.feed.presentation.dto.request.FeedRequest;
import com.example.springstudy.domain.feed.presentation.dto.response.FeedResponse;
import com.example.springstudy.domain.feed.service.CreateFeedService;
import com.example.springstudy.domain.feed.service.DeleteFeedService;
import com.example.springstudy.domain.feed.service.QueryFeedService;
import com.example.springstudy.domain.feed.service.UpdateFeedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final DeleteFeedService deleteFeedService;
    private final UpdateFeedService updateFeedService;
    private final QueryFeedService queryFeedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@RequestBody @Valid FeedRequest request) {
        createFeedService.createFeed(request);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.deleteFeed(feedId);
    }

    @PatchMapping("/{feed-id}")
    public void updateFeed(@RequestBody @Valid FeedRequest request, @PathVariable("feed-id") Long feedId) {
        updateFeedService.updateFeed(request, feedId);
    }

    @GetMapping("/{feed-id}")
    public FeedResponse getFeed(@PathVariable("feed-id") Long feedId) {
        return queryFeedService.getFeed(feedId);
    }

}