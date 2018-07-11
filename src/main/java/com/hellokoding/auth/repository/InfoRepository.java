package com.hellokoding.auth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hellokoding.auth.model.Info;
//import com.hellokoding.auth.model.Mail;

public interface InfoRepository extends JpaRepository<Info,Long>
{
	
	List<Info> findByLocAndLang(String loc,String lang);
	//List<String> findAllLoc();
	
	@Query("select distinct s.loc from Info s")
    List<Object> getLoc();
	
	@Query("select distinct s.lang from Info s")
    List<Object> getLang();
	
	@Query("select s.tickets from Info s where s.movie=?1")
	Integer getTickets(String movie);
	
	  @Transactional
	  @Modifying(clearAutomatically=true)
	  @Query("update Info s set s.tickets=?2 where s.movie=?1")
	Integer updateTickets(String movie,Integer newtick);
	
	//@Query("select s.tickets from Mail s where s.movie=?1")
	
	
	
	//List<Mail> findByFrmaAndMt(String from, String type);

}
