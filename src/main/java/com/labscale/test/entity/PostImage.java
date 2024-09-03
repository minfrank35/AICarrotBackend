package com.labscale.test.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostImage {
    private Integer id;
    private Integer postId;
    private String imageUrl;
}