package com.hellokoding.auth.web;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.Info;
import com.hellokoding.auth.model.Profile;
import com.hellokoding.auth.service.InfoService;

import com.hellokoding.auth.service.ProfileService;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;

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

@Controller
public class UserController {
	
	public String loc;
	public String lang;
	public String dateb;

	
    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private ProfileService profileService;


    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    	private static final Logger logger = Logger.getLogger(UserController.class);

    
    
    

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

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

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	
    	logger.info("Entered welcome page!");
    	
   	List<Object> lo=infoService.getLoc();
   	model.addAttribute("locations", lo);
   	
   	List<Object> lan=infoService.getLang();
   	model.addAttribute("languages", lan);
    	
	
        return "welcome";
    }
    
    
    @RequestMapping(value = {"/choices"})
    public String options(Model model,@RequestParam(name="locations") String locations,@RequestParam(name="languages") String languages,@RequestParam(name="date") String date) {
    	
    	
    	
    	List<Info> list=infoService.getAllMoviesByLocAndLang(locations,languages);
    	model.addAttribute("list", list);
    	model.addAttribute("location", locations);
    	model.addAttribute("languages", languages);
    	model.addAttribute("dateb", date);


    	loc=locations;
    	lang=languages;
    	dateb=date;
       

    	
        return "choices";
    }
    
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String options(Model model,Principal p) {
    	
    	
    	
    	
    	String uname=p.getName();
    	logger.info("Entered profile page for user :!"+uname);

    	List<Profile> profile=profileService.getData(uname);
    	
    	model.addAttribute("profile", profile);

        return "profile";
    }
    
   
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(Model model,@RequestParam(name="movie") String movie,@RequestParam("tickets") Integer tickets,Principal p) {
       String uname=p.getName();
       int tick=infoService.getTickets(movie,loc);
       int newtick=tick-(tickets);
       
       int updatetick=infoService.updateTickets(movie,newtick);

logger.info(""+updatetick);
       profileService.insertData(uname,loc,lang,movie,tickets,dateb);
       
    	return "redirect:/welcome";
    }
}
