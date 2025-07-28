package org.example.blogsp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogDto {
    private Integer id;
    private String title;
    private String content;
    private String categoryName;
}