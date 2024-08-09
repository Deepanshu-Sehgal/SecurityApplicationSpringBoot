package com.datricle.SpringSecurityDemo.SecurityApplication.controllers;


import com.datricle.SpringSecurityDemo.SecurityApplication.dto.LogInDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.dto.SignUpDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.dto.UserDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.services.AuthService;
import com.datricle.SpringSecurityDemo.SecurityApplication.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        UserDTO userDTO = userService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LogInDTO logInDTO, HttpServletRequest request, HttpServletResponse response) {
        String token = authService.logIn(logInDTO);
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }
}