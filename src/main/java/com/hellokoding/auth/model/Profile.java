package com.hellokoding.auth.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "profile")
public class Profile {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="uname")
	private String uname;
	
	
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="movie")
	private String movie;
	

@Column(name="loc")
private String loc;

@Column(name="lang")
private String lang;



	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

	public String getLang() {
	return lang;
}

public void setLang(String lang) {
	this.lang = lang;
}
	@Column(name="tickets")
	private Integer tickets;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dates")
    private Date dates;
	
	
	
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public Integer getTickets() {
		return tickets;
	}

	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public Profile(String uname, String movie, String loc, String lang, Integer tickets, Date dates) {
		super();
		this.id=id;
		this.uname = uname;
		this.movie = movie;
		this.loc = loc;
		this.lang = lang;
		this.tickets = tickets;
		this.dates = dates;
	}

	/*public Profile(String uname, String movie, Integer tickets, Date dates) {
		super();
		this.uname = uname;
		this.movie = movie;
		this.tickets = tickets;
		this.dates = dates;
	}
*/
	/*public Profile(String uname, String movie, Integer tickets) {
		super();
		this.uname = uname;
		this.movie = movie;
		this.tickets = tickets;
	}*/
	
	
	
}