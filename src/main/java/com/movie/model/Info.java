package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author suprija
 * Info entity class 
 */
@Entity
@Table(name = "info")
public class Info
{
		@Id
		@GeneratedValue
		private Long id;

		@Column(name = "loc")
		private String loc;

		@Column(name = "lang")
		private String lang;

		@Column(name = "theatre")
		private String theatre;
		
		@Column(name="movie")
		private String movie;
		
		@Column(name="tickets")
		private Integer tickets;
		
		public Integer getTickets() {
			return tickets;
		}

		public void setTickets(Integer tickets) {
			this.tickets = tickets;
		}

		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String getLoc() {
			return loc;
		}

		public void setLoc(String loc) {
			this.loc = loc;
		}

		public String getLang() {
			return lang;
		}

		public void setLang(String lang) {
			this.lang = lang;
		}

		public String getTheatre() {
			return theatre;
		}

		public void setTheatre(String theatre) {
			this.theatre = theatre;
		}

		public String getMovie() {
			return movie;
		}

		public void setMovie(String movie) {
			this.movie = movie;
		}

		public Info()
		{
			
		}
		

		public Info(Long id, String loc, String lang, String theatre, String movie, Integer tickets) {
			super();
			this.id = id;
			this.loc = loc;
			this.lang = lang;
			this.theatre = theatre;
			this.movie = movie;
			this.tickets = tickets;
		}
	
}
