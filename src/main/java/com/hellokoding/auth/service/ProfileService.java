package com.hellokoding.auth.service;

import java.util.List;



import com.hellokoding.auth.model.Profile;


public interface ProfileService {

	void insertData(String uname,String loc,String lang,String movie,Integer tickets,String timeStamp);
	List<Profile> getData(String uname);

	
}
