package com.example.springstudy.domain.feed.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedRequest {

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 50, message = "제목은 50자 이내로 입력해주세요.")
    private String title;

    @NotBlank(message = "본문을 입력해주세요.")
    @Size(max = 5000, message = "내용은 5000자 이내로 입력해주세요.")
    private String content;

}