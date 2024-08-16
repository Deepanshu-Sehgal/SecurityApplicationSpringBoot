package com.datricle.SpringSecurityDemo.SecurityApplication.services;

import com.datricle.SpringSecurityDemo.SecurityApplication.entities.Session;
import com.datricle.SpringSecurityDemo.SecurityApplication.entities.User;
import com.datricle.SpringSecurityDemo.SecurityApplication.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private SessionRepository sessionRepository;
    private final int SESSION_LIMIT = 2;

    public void generateNewSession(User user, String refreshToken) {

        List<Session> userSessions = sessionRepository.findByUser(user);
        if (userSessions.size() == SESSION_LIMIT) {
            userSessions.sort(Comparator.comparing(Session::getLastUsedAt));

            Session leastRecentlyUsedSession = userSessions.getFirst();
            sessionRepository.delete(leastRecentlyUsedSession);
        }

        Session newSession = Session.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();
        sessionRepository.save(newSession);

    }

    public void validateSession(String refreshToken){
        Session session = sessionRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new SessionAuthenticationException("Session not found for  refreshToken:" + refreshToken));
    }
}