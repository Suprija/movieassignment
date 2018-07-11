package com.hellokoding.auth.service;

import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Info;
//import com.hellokoding.auth.model.Mail;
import com.hellokoding.auth.repository.InfoRepository;
//import com.hellokoding.auth.repository.MailRepository;

@Service
@Component
public class InfoServiceImpl implements InfoService 
{
	
	@Autowired 
	private InfoRepository infoRepository;
	@Override
	public List<Info> getAllMoviesByLocAndLang(String loc,String lang) 
	{
		
		List<Info> mails = infoRepository.findByLocAndLang(loc,lang); 
		return mails;
	}
	@Override
	public List<Object> getLoc() 
	{
		
		List<Object> loc = infoRepository.getLoc(); 
		return loc;
	}
	
	@Override
	public List<Object> getLang() 
	{
		
		List<Object> lang = infoRepository.getLang(); 
		return lang;
	}
	
	@Override
	public Integer getTickets(String movie,String loc) 
	{
		
		Integer tickets = infoRepository.getTickets(movie,loc); 
		return tickets;
	}
	
	@Override
	public Integer updateTickets(String movie,Integer newtick) 
	{
		
		Integer tickets = infoRepository.updateTickets(movie,newtick); 
		return tickets;
	}
	/*@Override
	public List<Mail> getAllMailsByFromaddAndType(String from, String type) 
	{
		List<Mail> mails =mailRepository.findByFrmaAndMt(from,type);
		return mails;
	}*/

}
