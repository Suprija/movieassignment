package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    

}
