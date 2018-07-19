package com.movie.model;

import java.util.Date;

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
	}

	@Column(name="movie")
	private String movie;
	

@Column(name="loc")
private String loc;

@Column(name="lang")
private String lang;

@Column(name="theatre")
private String theatre;

	public String getTheatre() {
	return theatre;
}

public void setTheatre(String theatre) {
	this.theatre = theatre;
}

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
	
	@Column(name="ticketclass")
	private String ticketclass;
	
	public String getTicketclass() {
		return ticketclass;
	}

	public void setTicketclass(String ticketclass) {
		this.ticketclass = ticketclass;
	}
	
	@Column(name="ticketsprice")
	private Integer ticketsprice;

	public Integer getTicketsprice() {
		return ticketsprice;
	}

	public void setTicketsprice(Integer ticketsprice) {
		this.ticketsprice = ticketsprice;
	}

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

	public Profile(Long id, String uname, String movie, String loc, String lang, String theatre, Integer tickets,
			String ticketclass, Integer ticketsprice, Date dates) {
		super();
		this.id = id;
		this.uname = uname;
		this.movie = movie;
		this.loc = loc;
		this.lang = lang;
		this.theatre = theatre;
		this.tickets = tickets;
		this.ticketclass = ticketclass;
		this.ticketsprice = ticketsprice;
		this.dates = dates;
	}

	

	
	

	
	
}