package com.trs.miniproject.Model;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer passengerId;
	private String passengerName;
	private Integer passengerAge;
//	private Integer numOfTickets;
//	@OneToOne(cascade =CascadeType.ALL)
//	@JoinColumn(name = "FK_TICKET_ID")
	//private Integer ticketId;
	
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	
//	public Integer getNumOfTickets() {
//		return numOfTickets;
//	}
//	public void setNumOfTickets(Integer numOfTickets) {
//		this.numOfTickets = numOfTickets;
//	}
	
	public Passenger(Integer passengerId, String passengerName, Integer passengerAge) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
//		this.numOfTickets = numOfTickets;
	}
	public Passenger() {
	
	}	
}


	
