package com.trs.miniproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trs.miniproject.Model.Passenger;
import com.trs.miniproject.Model.Ticket;
import com.trs.miniproject.Model.Train;
import com.trs.miniproject.Service.PassengerService;
import com.trs.miniproject.Service.TicketService;
import com.trs.miniproject.Service.TrainService;
@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	TicketService ticketservice;
	TrainService trainservice;
	PassengerService passengerservice;

	@PostMapping("/addticket")
	public Ticket saveticket(@RequestBody Ticket ticket) {
		return ticketservice.save(ticket);
		
	}
	
	@GetMapping("/fetch-all-ticket")
	public List<Ticket> getAllTickets() {
		return (List<Ticket>) ticketservice.findAll();
		
}
	@GetMapping("/fetch-all-ticketafter-concession")
	public Ticket getAllTicket(Integer id,Integer ticketAmount ) {
		return ticketservice.Concession(id,ticketAmount); 
		
	}
	@PostMapping("/addtrain")
	public Train savetrain(@RequestBody Train train) {
		return trainservice.save(train);
		
	}
//	@DeleteMapping("/check")
//	public void deleteTrain(@PathVariable Integer id) {
//		 ticketservice.deleteticket(id);
	//}
	@GetMapping("/fetch-all-train")
	public List<Train> getAllTrains() {
		return (List<Train>) trainservice.findAll();
	}

@PostMapping("/addPassenger")
public String savePassenger(@RequestBody List<Passenger> passenger) {
	  passengerservice.saveAll(passenger);
	 return "passenger updated";
	
}
@DeleteMapping("/deleteticket/{id}")
	 public void deleteticket(@PathVariable Integer id) {
		 ticketservice.deleteticket(id);
		 //return "ticket deleted";
		 
	 }
	 

//@PutMapping("/updatePassenger/{id}/{name}")
// public String updatePassenger(@PathVariable Integer id,@PathVariable String name) {
//	 passengerservice.updatePassenger(id,name);
//	 return "Passenger Updated";
//	 
//}

@PutMapping("/updateticketdate/{id}/{travellingdate}")
 public String updateticketdate(@PathVariable Integer id,@PathVariable Integer travellingdate) {
	ticketservice.updateticketdate(id,travellingdate);
	 return "travellingdate updated";
	 
}
@PutMapping("/updateticketsource/{id}/{travellingSource}")
public String updateticketsource(@PathVariable Integer id,@PathVariable String travellingSource) {
	ticketservice.updateticketsource(id,travellingSource);
	 return "travelling source updated";
	 
//@PutMapping("/updatePassenger/{id}/{name}")
// public String updatePassenger(@PathVariable Integer id,@PathVariable String name) throws Exception{
//	 passengerservice.updatePassenger(id,name);
//	 return "Passenger Updated";
//	 
}
@PutMapping("/updateTrainStatus/{id}/{status}")
public String updateTrainStatus(@PathVariable Integer id,@PathVariable boolean status){
	 ticketservice.updateTrainStatus(id,status);
	 return "trainstatus updated";
	 
}
@GetMapping("/fetch-all-passenger")
public List<Passenger> getAllPassengers() {
	return passengerservice.getAll();
	
	
}
}

