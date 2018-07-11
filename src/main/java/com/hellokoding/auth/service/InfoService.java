package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.Info;
//import com.hellokoding.auth.model.Mail;

public interface InfoService 
{
	List<Info> getAllMoviesByLocAndLang(String loc,String lang);
	List<Object> getLoc();
	List<Object> getLang();
	Integer getTickets(String movie);
	Integer updateTickets(String movie,Integer newtick);

	//List<Mail> getAllMailsByFromaddAndType(String from, String type);
}

