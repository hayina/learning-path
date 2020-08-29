package com.blog.services.interfaces;

import com.blog.entities.Post;
import com.blog.models.PostDto;

import java.util.List;

public interface IBlogService {


    Post savePost(PostDto postDto);
    void deletePost(Integer postId);
    List<?> searchPosts();
    Post getPost(Integer postId);

}
