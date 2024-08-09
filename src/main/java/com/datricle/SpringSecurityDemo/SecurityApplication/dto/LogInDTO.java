package com.datricle.SpringSecurityDemo.SecurityApplication.dto;

import lombok.Data;

@Data
public class LogInDTO {
    private String email;
    private String password;

}