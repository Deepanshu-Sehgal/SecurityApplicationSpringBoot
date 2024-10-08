package com.datricle.SpringSecurityDemo.SecurityApplication.controllers;


import com.datricle.SpringSecurityDemo.SecurityApplication.dto.PostDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
//    @PreAuthorize("hasRole('USER')")
//    @PreAuthorize("hasAnyRole('USER','ADMIN') AND hasAuthorities('POST_VIEW')")
    @PreAuthorize("@postSecurity.isOwnerOfThePost(#postId)")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost) {
        return postService.createNewPost(inputPost);
    }

}