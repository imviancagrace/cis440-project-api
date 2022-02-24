package com.cis440.model.request;

import com.cis440.constant.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NonNull
public class PostRequest {
    private String title;
    private String content;
    private Integer rating;
    private Integer ownerId;
    private Department department;
}
