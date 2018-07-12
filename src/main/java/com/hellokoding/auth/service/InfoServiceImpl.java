package com.hellokoding.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Info;
import com.hellokoding.auth.repository.InfoRepository;

@Service
@Component
public class InfoServiceImpl implements InfoService 
{
	
	@Autowired 
	private InfoRepository infoRepository;
	@Override
	public List<Info> getAllMoviesByLocAndLang(String loc,String lang) 
	{
		
		return infoRepository.findByLocAndLang(loc,lang); 
		 
	}
	@Override
	public List<Object> getLoc() 
	{
		
		return infoRepository.getLoc(); 
		 
	}
	
	@Override
	public List<Object> getLang() 
	{
		
		return infoRepository.getLang(); 
		
	}
	
	@Override
	public Integer getTickets(String movie,String loc) 
	{
		
		return infoRepository.getTickets(movie,loc); 
		
	}
	
	@Override
	public Integer updateTickets(String movie,Integer newtick) 
	{
		
		return infoRepository.updateTickets(movie,newtick); 
		 
	}
	

}
