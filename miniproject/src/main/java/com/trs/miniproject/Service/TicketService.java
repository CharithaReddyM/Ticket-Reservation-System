package com.trs.miniproject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trs.miniproject.Exception.NumOfTicketsExceedException;
import com.trs.miniproject.Exception.TicketIdUniqueException;
import com.trs.miniproject.Exception.TicketNotFound;
import com.trs.miniproject.Exception.TrainNotFound;
import com.trs.miniproject.Model.Passenger;
//import com.trs.miniproject.Exception.PassengerNotFound;
//import com.trs.miniproject.Exception.TicketIdUniqueException;
//import com.trs.miniproject.Model.Passenger;
import com.trs.miniproject.Model.Ticket;
import com.trs.miniproject.Model.Train;
import com.trs.miniproject.Repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	 private TicketRepository ticketrepository;
	
     
//	 public List<Ticket> getALlUsers() {
//	     return (List<Ticket>) ticketrepository.findAll();
//	 }


	 public Ticket getTicket(int id) throws Exception {
	     Ticket ticket= ticketrepository.findByticketId(id);
	     if(ticket!=null){
	         return ticket;
	     }
	     else{
	         throw new Exception();
	     }
	 }
	 public  Ticket check(int id)  {
			Ticket ticket = findByTicketId(id);
			if(ticket.getTicketId()!=id) {
				 return  ticketrepository.findById(id).get();
			
				  }
			else {
                     throw new TicketIdUniqueException();
			}
			
		}


	public Ticket findByTicketId(Integer id) {
	 return  ticketrepository.findById(id).get();
	}


	public Ticket save(Ticket ticket) 
	
	{
		if(ticket.getPassenger().size()<=3) {

		return ticketrepository.save(ticket);
	}
		else {
			throw new NumOfTicketsExceedException();
		}
	}
	  public Ticket Concession(Integer id,Integer ticketAmount ) {
			Ticket ticket = findByTicketId(id);

		if( ((Passenger) ticket.getPassenger()).getPassengerAge()>=60) {
			ticketAmount=ticketAmount-((ticketAmount)/10);
			ticket.setTicketAmount(ticketAmount);
			return ticketrepository.save(ticket);
          }
		else {
			return ticket;
		}
	}


	public List<Ticket> findAll() {
	
		return (List<Ticket>) ticketrepository.findAll();
	}


	public Ticket updateticketdate(Integer id, Integer travellingdate)  {
		Ticket ticket = findByTicketId(id);
		if(ticket.getTicketId() == id) {
			ticket.setTravellingDate(travellingdate);
			return ticketrepository.save(ticket);

		}
		else 
		{
			throw new TicketNotFound();
		}
	}

	public Ticket updateticketsource(Integer id, String travellingSource) {
		Ticket ticket = findByTicketId(id);
		if(ticket.getTicketId() == id) {
			ticket.setSource(travellingSource);
			return ticketrepository.save(ticket);

		}
		else 
		{
			throw new TicketNotFound();
		}
	}
	public void deleteticket(Integer id) {
		Ticket ticket = findByTicketId(id);  
	  if(ticket.getTrain().getIsAvailable()==false) {
		   ticketrepository.deleteAll(); 
		 System.out.println("ticket deleted due to not availability");
	  }
	  else {
		 ticketrepository.save(ticket);
		 System.out.println("ticked reserved");
	  }
	}
	public Ticket updateTrainStatus(Integer id, boolean status) {
		Ticket ticket = findByTicketId(id);
		if(ticket.getTrain().getTrainId() == id) {
			ticket.getTrain().setIsAvailable(status);
			return ticketrepository.save(ticket);

		}
		else 
		{   try {
			throw new TrainNotFound();
		}catch(Exception e) {
			System.out.println("Exception");
		
		}
		}
	
		 try {
			if(ticket.getTrain().getIsAvailable()==false) {
				 
				   ticketrepository.deleteAll(); 
			//return "ticket deleted due to not availability";
			  }
			 
			  else {
				  ticketrepository.save(ticket);
				 //return "ticked reserved";
			  }
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		 return null;
	
	}
		
	}

		



