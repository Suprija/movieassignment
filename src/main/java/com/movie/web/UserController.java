package com.movie.web;

import com.movie.model.History;
import com.movie.model.Info;
import com.movie.model.Tickets;
import com.movie.model.User;
import com.movie.repository.HistoryRepository;
import com.movie.repository.InfoRepository;
import com.movie.service.SecurityService;
import com.movie.service.UserService;

import com.movie.validator.UserValidator;

import java.security.Principal;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class contains the logic for controllers
 * @author suprija
 *
 */

@Controller
public class UserController {
	
	public String loc;
	public String lang;
	public String dateb;
	public int price;

	
    @Autowired
    private UserService userService;

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private HistoryRepository historyRepository;


    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    	private static final Logger logger = Logger.getLogger(UserController.class);

 /**
 * To display registration page
 * @param model to set attributes in jsp page
 * @return registration page for new users to register
 */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    /**
     * To display welcome page after successful registration; display registration page for unsuccessful registration
     * @param userForm user object contains details entered by user
     * @param bindingResult has the errors resulted due to information entered by the user
     * @param model to set attributes in jsp page
     * @return registration page for unsuccessful registration ;welcome page for successful registration
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    /**
     * To authenticate user and redirect him to welcome page; redirect to login page for unsuccessful authentication
     * @param model to set attributes in jsp page
     * @param error
     * @param logout
     * @param p It is the currently logged in user
     * @return login page for unsuccessful authentication or logout ;welcome page for authenticated user
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout,Principal p) {
        
    	logger.info("Entered login page!");

    	if(p != null)
    	{
    		
    		return "redirect:/welcome";
    	}
    	
    	if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    /**
     * To display welcome page for authenticated user after logging in
     * @param model to set attributes in jsp page
     * @return welcome page for authenticated user
     */
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	
    	logger.info("Entered welcome page!");
    	
   	List<Object> lo=infoRepository.getLoc();
   	model.addAttribute("locations", lo);
   	
   	List<Object> lan=infoRepository.getLang();
   	model.addAttribute("languages", lan);
    	
	
        return "welcome";
    }
    
    /**
     * To display the movie options based on the location,language and date chosen by user
     * @param model to set attributes in jsp page
     * @param locations selected by the user
     * @param languages selected by the user
     * @param date selected by the user
     * @return choices for chosen location, language and date
     */
    @RequestMapping(value = {"/choices"})
    public String options(Model model,@RequestParam(name="locations") String locations,@RequestParam(name="languages") String languages,@RequestParam(name="date") String date) {
    	
    	List<Info> list=infoRepository.findByLocAndLang(locations,languages);
    	model.addAttribute("list", list);
    	model.addAttribute("location", locations);
    	model.addAttribute("languages", languages);
    	model.addAttribute("dateb", date);

    	loc=locations;
    	lang=languages;
    	dateb=date;
       
    	return "choices";
    }
    
    
    /**
     * To display the booking history of user
     * @param model to set attributes in jsp page
     * @param p It is the currently logged in user
     * @return booking history of logged in user
     */
    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String options(Model model,Principal p) {
    	
    	String uname=p.getName();
    	logger.info("Entered history page for user :"+uname);

    	List<History> history=historyRepository.getData(uname);
    	
    	model.addAttribute("history", history);

        return "history";
    }
    
    /**
     * 
     * @param input is model attribute from choices.jsp page
     * @param p It is the currently logged in user
     * @return redirect to /thankyou for successful ticket booking
     */
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(@ModelAttribute("input") Tickets input,Principal p) {
		 String uname=p.getName();
		 String classticket = null;
	        String theatre;
	        String selmovie=input.movie;
	        theatre=infoRepository.getTheatre(selmovie,loc,lang);
	        int tick=infoRepository.getTickets(selmovie,loc);
	        int newtick=tick-(input.tickets);
	        int updatetick=infoRepository.updateTickets(selmovie,newtick);
	        logger.info(""+updatetick);
		 int pr=getPrice(input);
		 if(input.ticketclass==80)
	     	   classticket="Silver";
	        else if(input.ticketclass==100)
	     	   classticket="Gold";
	        else if(input.ticketclass==150)
	     	   classticket="Platinum";

		 historyRepository.insertData(uname,loc,lang,selmovie,theatre,input.tickets,classticket,pr,dateb);
    	return "redirect:/thankyou"; 
    }
    
    /**
     * Thank you page after payment
     * @return thankyou page
     */
    @RequestMapping(value = "/thankyou", method = RequestMethod.GET)
    public String thankyou()
    {
    	return "thankyou";
    }
    
    /**
     * To calculate price of booked tickets
     * @param input Tickets object
     * @return tickets price
     */
	 public int getPrice(Tickets input) {
	        price=input.tickets*input.ticketclass;
	        return price;
	      }
    
}
