package com.hellokoding.auth.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import com.hellokoding.auth.model.Mail;
import com.hellokoding.auth.model.Profile;
import com.hellokoding.auth.repository.ProfileRepository;

@Service
@Component
public class ProfileServiceImpl implements ProfileService  {

	@Autowired 
	private ProfileRepository profileRepository;
	
	@Override
	public void insertData(String uname,String loc,String lang,String movie,Integer tickets,String timeStamp)
	{
		
		profileRepository.insertData(uname,loc,lang,movie,tickets,timeStamp); 
		
	}
	/*@Override
	public List<String> findData(String uname) 
	{
		
		List<String> profile = profileRepository.findData(uname); 
		return profile;
	}*/
	
	@Override
	public List<Profile> getData(String uname)
	{
		
		List<Profile> profile=profileRepository.getData(uname); 
		return profile;
		
	}	
}
