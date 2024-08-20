package com.datricle.SpringSecurityDemo.SecurityApplication.utils;

import com.datricle.SpringSecurityDemo.SecurityApplication.dto.PostDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.entities.User;
import com.datricle.SpringSecurityDemo.SecurityApplication.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurity {

    private final PostService postService;

    boolean isOwnerOfThePost(Long postId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostDTO post = postService.getPostById(postId);
        return post.getAuthor().getId().equals(user.getId());


    }

}