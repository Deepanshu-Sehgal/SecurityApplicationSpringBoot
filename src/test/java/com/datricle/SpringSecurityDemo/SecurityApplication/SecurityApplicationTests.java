package com.datricle.SpringSecurityDemo.SecurityApplication;

import com.datricle.SpringSecurityDemo.SecurityApplication.entities.User;
import com.datricle.SpringSecurityDemo.SecurityApplication.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
        User user = new User(4L, "deep@gmail.com", "1234");

        String token = jwtService.generateToken(user);
        System.out.println(token);

        Long id = jwtService.getUserFromToken(token);
        System.out.println(id);
    }


}