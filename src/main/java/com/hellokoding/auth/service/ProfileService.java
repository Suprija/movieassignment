package com.hellokoding.auth.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Profile;


public interface ProfileService {

	void insertData(String uname,String loc,String lang,String movie,Integer tickets,String timeStamp);
	List<Profile> getData(String uname);

	//List<String> findData(String uname);
	
}
