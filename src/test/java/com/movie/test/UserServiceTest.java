package com.movie.test;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.model.User;

import com.movie.service.UserService;

@Transactional
public class UserServiceTest extends AbstractTest {
	@Autowired
	private UserService userService;
	
	@Test
    public void testGetByUsername() throws Exception {

        String username="suprijarao";
        User entity = userService.findByUsername(username);
Assert.assertNotNull("failure- expected entitiy", entity);
Assert.assertEquals("expected attribute string doesnot match","suprijarao", entity.getUsername());
   
}
	@Test
    public void saveUser() throws Exception {
		User user=new User("testuser");
		
        userService.save(user);
		
Assert.assertNotNull("failure- expected entitiy", userService.findByUsername("testuser"));
Assert.assertEquals("expected attribute string doesnot match","testuser", user.getUsername());
   
}
	

}