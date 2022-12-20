package com.trs.miniproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trs.miniproject.Model.Train;
import com.trs.miniproject.Service.TrainService;
@RestController
@RequestMapping("/train")
public class TrainController {
	@Autowired
	TrainService trainservice;
//	@PostMapping("/addtrain")
//	public Train savetrain(@RequestBody Train train) {
//		return trainservice.save(train);
//		
//	}
	@PutMapping("/updatetrain/{id}/{traindate}")
	 public String updateTrain(@PathVariable Integer id,@PathVariable Integer traindate){
		trainservice.updateTrain(id,traindate);
		 return "traindate Updated";
	}
		 
//		 @PutMapping("/updateTrainStatus/{id}/{status}")
//		 public String updateTrainStatus(@PathVariable Integer id,@PathVariable boolean status){
//			 trainservice.updateTrainStatus(id,status);
//			 return "trainstatus updated";
//			 
//		 }
		 @PutMapping("/updateTrainCapacity/{id}/{capacity}")
		 public String updateTrainStatus(@PathVariable Integer id,@PathVariable Integer  capacity){
			 trainservice.updateTrainCapacity(id,capacity);
			 return "traincapacity Updated";
		 }
	@GetMapping("/fetch-all")
	public List<Train> getAllTrains() {
		return (List<Train>) trainservice.findAll();
		
}
}
