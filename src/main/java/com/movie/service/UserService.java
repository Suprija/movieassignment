package com.movie.service;


import com.movie.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}