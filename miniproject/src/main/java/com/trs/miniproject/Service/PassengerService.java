package com.trs.miniproject.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trs.miniproject.Exception.NumOfTicketsExceedException;
//import com.trs.miniproject.Exception.NumOfTicketsExceedException;
import com.trs.miniproject.Exception.PassengerNotFound;
import com.trs.miniproject.Exception.TicketIdUniqueException;
import com.trs.miniproject.Model.Passenger;
import com.trs.miniproject.Model.Ticket;
import com.trs.miniproject.Repository.PassengerRepository;



@Service
public class PassengerService {
 @Autowired
 public PassengerRepository passengerrepository;
 


 public Passenger findBypassengerId(Integer id){
     Passenger passenger= passengerrepository.findById(id).get();
     if(passenger!=null){
         return passenger;
     }
     else{
         throw new PassengerNotFound();
     }
 }




public List<Passenger> getAll() {
	return (List<Passenger>) passengerrepository.findAll();
}


	
public Passenger updatePassenger(Integer id,String name){
	Passenger passenger = findBypassengerId(id);
	if(passenger.getPassengerId() == id) {
		passenger.setPassengerName(name);
		return passengerrepository.save(passenger);

	}else {
		throw new PassengerNotFound();
	}
}




public  Passenger saveAll(List<Passenger> passenger) {
	return (Passenger) passengerrepository.findAll();

	
}



}
