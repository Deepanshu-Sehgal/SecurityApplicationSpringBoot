package com.datricle.SpringSecurityDemo.SecurityApplication.services;


import com.datricle.SpringSecurityDemo.SecurityApplication.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);
}