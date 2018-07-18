package com.movie.test;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.model.User;
import com.movie.repository.UserRepository;
import com.movie.service.UserService;

@Transactional
public class UserServiceTest extends AbstractTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
public void testGetByUsername() throws Exception {
User user=new User("testuser");
	
    userRepo.save(user);
    String username="testuser";
    User entity = userService.findByUsername(username);
Assert.assertNotNull("failure- expected entitiy", entity);
Assert.assertEquals("expected attribute string doesnot match","testuser", entity.getUsername());

}
	

}