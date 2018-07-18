package com.movie.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.movie.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long> {

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "insert into profile (uname,loc,lang,movie, tickets,dates) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	void insertData(String uname,String loc,String lang,String movie, Integer tickets,String timeStamp);
	
	
	@Query("select p from Profile p where p.uname=?1")
	List<Profile> getData(String uname);
	
	

	
}
