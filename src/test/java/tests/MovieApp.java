package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hellokoding.auth.WebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WebApplication.class)
public class MovieApp {
	@Test
	public void contextLoads() {
	}
	
}