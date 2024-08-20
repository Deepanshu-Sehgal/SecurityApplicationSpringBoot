package com.datricle.SpringSecurityDemo.SecurityApplication.dto;

import com.datricle.SpringSecurityDemo.SecurityApplication.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String description;


    private UserDTO author;
}