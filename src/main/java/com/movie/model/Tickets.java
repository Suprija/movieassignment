package com.movie.model;

public class Tickets {
	public String movie ;
	public int tickets; 
	public int ticketclass ;
	
	public Tickets()
	{}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getTickets() {
		return tickets;
	}

	public Tickets(String movie, int tickets, int ticketclass) {
		this.movie = movie;
		this.tickets = tickets;
		this.ticketclass = ticketclass;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public int getTicketclass() {
		return ticketclass;
	}

	public void setTicketclass(int ticketclass) {
		this.ticketclass = ticketclass;
	}
	
	
}
