package com.datricle.SpringSecurityDemo.SecurityApplication.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String name;
}