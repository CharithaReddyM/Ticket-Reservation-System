package com.trs.miniproject.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trs.miniproject.Model.Passenger;
import com.trs.miniproject.Service.PassengerService;
@RestController
@RequestMapping("/passenger")

public class PassengerController {
	@Autowired
	PassengerService passengerservice;
	
//	@PostMapping("/addPassenger")
//	public String savePassenger(@RequestBody List<Passenger> passenger) {
//		 passengerservice.saveAll(passenger);
//		
//		 return "Passenger Added";
		
	//}
	@PutMapping("/updatePassenger/{id}/{name}")
	 public String updatePassenger(@PathVariable int id,@PathVariable String name){
		 passengerservice.updatePassenger(id,name);
		 return "Passenger Updated";
		 
	}

	@GetMapping("/fetch-all")
	public List<Passenger> getAllPassengers() {
		return passengerservice.getAll();
		
}
}
