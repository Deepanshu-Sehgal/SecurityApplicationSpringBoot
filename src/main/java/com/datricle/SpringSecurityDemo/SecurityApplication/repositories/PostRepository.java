package com.datricle.SpringSecurityDemo.SecurityApplication.repositories;


import com.datricle.SpringSecurityDemo.SecurityApplication.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}