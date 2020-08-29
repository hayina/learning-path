package com.blog.services;

import com.blog.entities.Post;
import com.blog.entities.Tag;
import com.blog.models.PostDto;
import com.blog.repositories.PostRepo;
import com.blog.services.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BlogService implements IBlogService {

    private PostRepo postRepo;

    @Autowired
    public BlogService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    @Transactional
    public Post savePost(PostDto postDto) {

        boolean editMode = postDto.getId() != null;

        var post = editMode ? postRepo.getOne(postDto.getId()) : new Post();
//        var post = editMode ? postRepo.findById(postDto.getId()).get() : new Post();

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setType(postDto.getType());

        var currentTime = new Date();

        post.setLive(postDto.isLive());
        post.setLiveAt(postDto.isLive() ? currentTime : null);


        if(editMode) {
            post.setLastModifiedAt(currentTime);
        }
        else {
            post.setCreatedAt(currentTime);
            postRepo.save(post);
        }

        /**
         * ToMany relationships
         */

        // delete tags
        post.getTags().removeIf(entityTag -> postDto.getTags().stream().noneMatch(dtoTag -> dtoTag.equals(entityTag)));

        // add new tags
        postDto.getTags().stream().forEach(dtoTag -> {
            if(post.getTags().stream().noneMatch(entityTag -> entityTag.equals(dtoTag))){
                post.getTags().add(new Tag(dtoTag));
            }
        });




        return post;
    }

    @Override
    @Transactional
    public void deletePost(Integer postId) {
        postRepo.deleteById(postId);
    }

    @Override
    public List<?> searchPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPost(Integer postId) {
        return postRepo.findById(postId).orElseThrow(() -> new EntityNotFoundException());
    }
}
