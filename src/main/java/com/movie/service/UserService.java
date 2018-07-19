package com.movie.service;


import com.movie.model.User;

/**
 * This interface provides abstract methods that has to be implemented by service implementation classes
 *
 * @author suprija
 *
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}