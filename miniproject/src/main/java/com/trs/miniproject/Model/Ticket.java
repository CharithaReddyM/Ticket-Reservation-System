package com.trs.miniproject.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer ticketId;
	private String source;
	private String destination;
	private  Integer seatAllotted;
	private  Integer travellingDate;
	private  Integer arrivalDate;
	private  Integer ticketAmount;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinColumn(name = "passengerId")
	private List<Passenger> passenger;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "trainId")
	private Train train;
	
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getSeatAllotted() {
		return seatAllotted;
	}
	public void setSeatAllotted(Integer seatAllotted) {
		this.seatAllotted = seatAllotted;
	}
	public Integer getTravellingDate() {
		return travellingDate;
	}
	public void setTravellingDate(Integer travellingDate) {
		this.travellingDate = travellingDate;
	}
	public Integer getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Integer arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Integer getTicketAmount() {
		return ticketAmount;
	}
	public void setTicketAmount(Integer ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	
	public Ticket(Integer ticketId, String source, String destination, Integer seatAllotted, Integer travellingDate,
			Integer arrivalDate, Integer ticketAmount, List<Passenger> passenger, Train train) {
		super();
		this.ticketId = ticketId;
		this.source = source;
		this.destination = destination;
		this.seatAllotted = seatAllotted;
		this.travellingDate = travellingDate;
		this.arrivalDate = arrivalDate;
		this.ticketAmount = ticketAmount;
		this.passenger = passenger;
		this.train = train;
	}
	public Ticket() {
		
	}
	
	
}
