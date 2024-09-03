package com.labscale.test.dao;

import com.labscale.test.entity.PostImage;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostImageMapper {

    @Insert("INSERT INTO PostImage(post_id, image_url) VALUES(#{postId}, #{imageUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertPostImage(PostImage postImage);

    @Select("SELECT * FROM PostImage WHERE id = #{id}")
    Optional<PostImage> getPostImageById(Integer id);

    @Select("SELECT * FROM PostImage WHERE post_id = #{postId}")
    List<PostImage> getPostImagesByPostId(Integer postId);

    @Select("SELECT * FROM PostImage")
    List<PostImage> getAllPostImages();

    @Update("UPDATE PostImage SET image_url = #{imageUrl} WHERE id = #{id}")
    void updatePostImage(PostImage postImage);

    @Delete("DELETE FROM PostImage WHERE id = #{id}")
    void deletePostImage(Integer id);
}