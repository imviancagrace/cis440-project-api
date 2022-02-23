package com.cis440.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private Integer rating;
    private Integer ownerId;
    private String department;
}
