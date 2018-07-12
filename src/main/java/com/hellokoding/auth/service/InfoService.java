package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.Info;

public interface InfoService 
{
	List<Info> getAllMoviesByLocAndLang(String loc,String lang);
	List<Object> getLoc();
	List<Object> getLang();
	Integer getTickets(String movie, String loc);
	Integer updateTickets(String movie,Integer newtick);

}

