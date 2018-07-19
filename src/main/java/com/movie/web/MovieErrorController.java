package com.movie.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class contains logic for error controlling
 * @author suprija
 *
 */
@Controller
public class MovieErrorController implements ErrorController  {
 
	/**
	 * To return error page if any error occurs
	 * @return error.jsp page
	 */
    @RequestMapping("/error")
    public String handleError() {
        
    	return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
