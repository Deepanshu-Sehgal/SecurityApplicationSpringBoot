package com.datricle.SpringSecurityDemo.SecurityApplication.dto;

import com.datricle.SpringSecurityDemo.SecurityApplication.entities.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {

    private String email;
    private String password;
    private String name;

    //don't use this in production application
    private Set<Role> roles;
}