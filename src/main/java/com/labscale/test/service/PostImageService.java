package com.labscale.test.service;

import com.labscale.test.dao.PostImageMapper;
import com.labscale.test.entity.PostImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostImageService {

    private final PostImageMapper postImageMapper;

    @Autowired
    public PostImageService(PostImageMapper postImageMapper) {
        this.postImageMapper = postImageMapper;
    }

    public void createPostImage(PostImage postImage) {
        postImageMapper.insertPostImage(postImage);
    }

    public Optional<PostImage> getPostImageById(Integer id) {
        return postImageMapper.getPostImageById(id);
    }

    public List<PostImage> getPostImagesByPostId(Integer postId) {
        return postImageMapper.getPostImagesByPostId(postId);
    }

    public List<PostImage> getAllPostImages() {
        return postImageMapper.getAllPostImages();
    }

    public void updatePostImage(PostImage postImage) {
        postImageMapper.updatePostImage(postImage);
    }

    public void deletePostImage(Integer id) {
        postImageMapper.deletePostImage(id);
    }
}