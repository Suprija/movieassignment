package com.hellokoding.auth.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.security.Principal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import com.hellokoding.auth.model.Info;
import com.hellokoding.auth.model.Profile;
import com.hellokoding.auth.service.InfoService;
import com.hellokoding.auth.service.ProfileService;
import com.hellokoding.auth.service.UserService;
import javax.servlet.Filter;
import javax.servlet.*;


@Transactional
public class UserControllerTest extends AbstractControllerTest {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProfileService profileService;
    
    @Autowired 
	private InfoService infoService;

  @Autowired
   private WebApplicationContext context;
    private MockMvc mockMvc;
   @Autowired
  private Filter springSecurityFilterChain;
    @Before
    public void setUp() {
 mockMvc = MockMvcBuilders.webAppContextSetup(context)
              .addFilters(springSecurityFilterChain)
              .defaultRequest(get("/").with(testSecurityContext()))
              .build();
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
	public void testRegistrationPageLoading() throws Exception 
	{
    	mockMvc.perform(MockMvcRequestBuilders.get("/registration"))
		                  .andExpect(status().isOk())
		                 
		                  .andExpect(view().name("registration"));
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
    	  mockMvc
      .perform(formLogin().user("suprijarao").password("suprijarao"))
      .andExpect(authenticated());
      
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
		  
		  List<Info> list=infoService.getAllMoviesByLocAndLang("Gachibowli","Hindi");	  	 
		  mockMvc.perform(get("/choices").param("locations","Gachibowli").param("languages","Hindi").param("date","2018-07-17"))
	     .andExpect(status().isOk())
	    		.andExpect(model().attribute("list", list))
	    		
	    		 .andDo(print())
	       		    .andExpect(view().name("choices"));
	  	 Assert.assertNotNull("failure- expected entitiy", list);
	    }   

      
      @Test
     @WithMockUser
      public void testProfile() throws Exception {
      	List<Profile> profile=profileService.getData("suprijarao");
      	List<Profile> profile1=profileService.getData("nouser");
		  
      	
    	  mockMvc.perform(MockMvcRequestBuilders.get("/profile"))
          .andExpect(status().isOk())
         
          .andExpect(view().name("profile"));
    	  
    	  assertFalse(profile.isEmpty());
    	  assertTrue(profile1.isEmpty());
      }
      
      
     
	    /*@Test
		  	public void confirmTicketSuccess() throws Exception {
		  
			Profile profile=new Profile();
			Date d=new Date();
			t.setDate(d);
			profile.setTickets("2");
			profile.setTrainname("hyderabadsuperfast");
			profile.setUname("lahari78");
			profileService.save(profile);
			
			String name = t.getUname();
			Assert.assertNotNull(name);
			
			List<Tickets> t1 = tkService.findByName(name);

		        Assert.assertEquals("lahari78", t1.get(0).getUname());
		        Assert.assertEquals("hyderabadsuperfast", t1.get(0).getTrainname());
		        Assert.assertEquals("2",t1.get(0).getTickets());
			
			
			
		  	  mockMvc.perform(post("/ticketconfirmation").param("nooftickets","2").param("trainname","hyderabadsuperfast").param("date","2018-07-17"))
	     .andExpect(status().isOk())
	    				    .andDo(print())
	       		    .andExpect(view().name("ticketconfirmation"));
	  	
	    }   
	 */

      

}
  