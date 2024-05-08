package com.devbyteschool.commentservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommentRequest {


    private String title;

    private String userId;

    private String blogId;


}
