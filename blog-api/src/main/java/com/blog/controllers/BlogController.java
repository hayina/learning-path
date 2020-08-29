package com.blog.controllers;


import com.blog.entities.Post;
import com.blog.models.PostDto;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/posts")
    Integer newPost(@Valid @RequestBody PostDto postDto){

        Post post = blogService.savePost(postDto);
        return post.getId();
    }

    @DeleteMapping("/posts/{postId}")
    void deletePost(@PathVariable Integer postId) {
        blogService.deletePost(postId);
    }

    @GetMapping("/posts")
    List<?> getAllPosts(){
        return blogService.searchPosts();
    }

    @GetMapping("/posts/{postId}")
    Post getPostById(@PathVariable Integer postId){
        return blogService.getPost(postId);
    }



//    @PutMapping("/posts")
//    Integer editPost(@Valid @RequestBody PostDto postDto){
//
//        Post post = blogService.savePost(postDto);
//        return post.getId();
//    }

}
