package com.movie.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.movie.model.History;

/**
 * This repository extends JpaRepository in which custom methods are declared depending upon our requirements
 * @author suprija
 *
 */
public interface HistoryRepository extends JpaRepository<History,Long> {

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "insert into history (uname,loc,lang,movie,theatre,tickets,ticketclass,ticketsprice,dates) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
	void insertData(String uname,String loc,String lang,String movie,String theatre, Integer tickets, String classticket,Integer price,String timeStamp);
	
	
	@Query("select h from History h where h.uname=?1")
	List<History> getData(String uname);
	
	

	
}
