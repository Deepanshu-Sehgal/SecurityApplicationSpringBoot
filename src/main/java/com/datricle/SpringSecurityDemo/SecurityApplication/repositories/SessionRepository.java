package com.datricle.SpringSecurityDemo.SecurityApplication.repositories;

import com.datricle.SpringSecurityDemo.SecurityApplication.entities.Session;
import com.datricle.SpringSecurityDemo.SecurityApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByUser(User user);

    Optional<Session> findByRefreshToken(String refreshToken);
}