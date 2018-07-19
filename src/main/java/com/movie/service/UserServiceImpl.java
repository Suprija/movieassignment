package com.movie.service;

import com.movie.model.User;
import com.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This class implements the UserService interface,provides methods to save the information provided by new users.
 * 
 * @author suprija
 *
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;
 
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  /**
   * This method saves the information provided by the user.
   * @param user is the User details that has to be stored 
   */
  @Override
  public void save(User user) {
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
  }

  /**
   * This method is used to find user based on username
   * @param username is the username of the user
   * @return User object is returned
   */
  @Override
  public User findByUsername(String username) {
      return userRepository.findByUsername(username);
  }
}