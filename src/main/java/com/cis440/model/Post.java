package com.cis440.model;

import com.cis440.constant.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Post {
    private Integer id;
    private String title;
    private Integer parentId;
    private String content;
    private Integer rating;
    private Integer ownerId;
    private LocalDateTime date;
    private Department department;
}
