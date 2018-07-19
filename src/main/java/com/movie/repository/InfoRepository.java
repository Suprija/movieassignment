package com.movie.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.movie.model.Info;

/**
 * This repository extends JpaRepository in which custom methods are declared depending upon our requirements
 * @author suprija
 *
 */
public interface InfoRepository extends JpaRepository<Info,Long>
{
	
	List<Info> findByLocAndLang(String loc,String lang);
	
	@Query("select distinct s.loc from Info s")
    List<Object> getLoc();
	
	@Query("select distinct s.lang from Info s")
    List<Object> getLang();
	
	@Query("select s.tickets from Info s where s.movie=?1 and s.loc=?2")
	Integer getTickets(String movie, String loc);
	
	  @Transactional
	  @Modifying(clearAutomatically=true)
	  @Query("update Info s set s.tickets=?2 where s.movie=?1")
	Integer updateTickets(String movie,Integer newtick);

	  
	  @Query("select s.theatre from Info s where s.movie=?1 and s.loc=?2 and s.lang=?3")  
	String getTheatre(String movie, String loc, String lang);
	
	
	
	

}
