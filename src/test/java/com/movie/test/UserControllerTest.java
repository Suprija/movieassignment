package com.movie.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.servlet.Filter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.movie.model.Info;
import com.movie.model.Tickets;
import com.movie.model.User;
import com.movie.repository.InfoRepository;
import com.movie.service.UserService;
import com.movie.web.UserController;



@Transactional
public class UserControllerTest extends AbstractControllerTest {
	
    
    
    @Autowired
    private UserService userService;
    
    @Autowired 
	private InfoRepository infoRepository;

  @Autowired
   private WebApplicationContext context;
    private MockMvc mockMvc;
   @Autowired
  private Filter springSecurityFilterChain;
   
   @Autowired
	private UserController uController;

   
    @Before
    public void setUp() {
 mockMvc = MockMvcBuilders.webAppContextSetup(context)
              .addFilters(springSecurityFilterChain)
              .defaultRequest(get("/").with(testSecurityContext()))
              .build();
 
        }
    @Test
	public void testRegistrationPageLoading() throws Exception 
	{
    	mockMvc.perform(MockMvcRequestBuilders.get("/registration"))
		                  .andExpect(status().isOk())
		                 
		                  .andExpect(view().name("registration"));
	}
    @Test
    public void testLogin() throws Exception {

        String uri = "/login";
     mockMvc.perform(MockMvcRequestBuilders.get(uri))
        		            .andExpect(status().isOk())
        		            .andDo(print())
        		            .andExpect(view().name("login"));
        }
  
   
@Test
      public void invalidLoginDenied() throws Exception {
        String loginErrorUrl = "/login?error";
        mockMvc
                .perform(formLogin().password("invalid"))
                .andExpect(redirectedUrl(loginErrorUrl))
                .andExpect(unauthenticated());
        } 
     
    
      @Test
    	public void testLoginSuccess() throws Exception {
    	  
    	  User user=new User();
    	  user.setUsername("suprijarao");
    	  user.setPassword("suprijarao");
    	  
    	  userService.save(user);
   mockMvc
      .perform(formLogin().user("suprijarao").password("suprijarao"))
      .andExpect(authenticated());
      
      }
      
      @Test
  	public void testLoginFailure() throws Exception {
  	  
  	  User user=new User();
  	  user.setUsername("suprija");
  	  user.setPassword("suprija");
  	  
  	  userService.save(user);
  	  
  	  mockMvc
    .perform(formLogin().user("suprija").password("suprijarao"))
    .andExpect(unauthenticated());
    
    }
      
      @Test
      @WithMockUser
      public void testWelcome() throws Exception {
      	
      	
    	  mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
          .andExpect(status().isOk())
         
          .andExpect(view().name("welcome"));
      }
     
      
      @Test
	  @WithMockUser
	  	public void testGetChoicesSuccess() throws Exception {
		  
		  List<Info> list=infoRepository.findByLocAndLang("Gachibowli","Hindi");	  	 
		  mockMvc.perform(get("/choices").param("locations","Gachibowli").param("languages","Hindi").param("date","2018-07-17"))
	     .andExpect(status().isOk())
	    		.andExpect(model().attribute("list", list))
	    		
	    		 .andDo(print())
	       		    .andExpect(view().name("choices"));
	  	 Assert.assertNotNull("failure- expected entitiy", list);
	    }   

      @Test
      public void unauthorizedProfileAccess() throws Exception {
          
    	  mockMvc.perform(MockMvcRequestBuilders.get("/profile"))
        .andExpect(unauthenticated());
      }
      
      @Test
     @WithMockUser
      public void testProfile() throws Exception {
		  
      	mockMvc.perform(MockMvcRequestBuilders.get("/profile"))
          .andExpect(status().isOk())
          .andExpect(view().name("profile"));
    	  
      }
      
      
      
      @Test	
      public void bookTicketTest()
      {
    	  
      	Tickets t = new Tickets();
      	t.setMovie("Lie");
      	t.setTickets(3);
      	t.setTicketclass(100);
      	uController.getPrice(t);
      	assertEquals(uController.price,300);
      }
      
}
  