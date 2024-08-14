package com.datricle.SpringSecurityDemo.SecurityApplication.services;

import com.datricle.SpringSecurityDemo.SecurityApplication.dto.SignUpDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.dto.UserDTO;
import com.datricle.SpringSecurityDemo.SecurityApplication.entities.User;
import com.datricle.SpringSecurityDemo.SecurityApplication.exceptions.ResourceNotFoundException;
import com.datricle.SpringSecurityDemo.SecurityApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new BadCredentialsException("User with this email " + username));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with this email " + userId));

    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public UserDTO signUp(SignUpDTO signUpDTO) {
        Optional<User> user = userRepository.findByEmail(signUpDTO.getEmail());
        if (user.isPresent()) {
            throw new BadCredentialsException("User with this email already exists" + signUpDTO.getEmail());
        }

        User toBeCreate = modelMapper.map(signUpDTO, User.class);
        toBeCreate.setPassword(passwordEncoder.encode(toBeCreate.getPassword()));

        User savedUser = userRepository.save(toBeCreate);
        return modelMapper.map(savedUser, UserDTO.class);
    }


    public User save(User newUser) {
        return userRepository.save(newUser);
    }
}