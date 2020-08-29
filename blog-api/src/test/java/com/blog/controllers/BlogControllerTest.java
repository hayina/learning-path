package com.blog.controllers;

import com.blog.entities.Post;
import com.blog.models.PostDto;
import com.blog.services.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Blog Controller")
class BlogControllerTest {

    @Mock
    BlogService blogService;

    @BeforeEach
    void init(){

    }

    @Test
    void savePost() {
        var blogController = new BlogController(blogService);


        when(blogService.savePost(any(PostDto.class))).thenReturn(new Post());
//        blogController.savePost(new PostDto());
    }

}