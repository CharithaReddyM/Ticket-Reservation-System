package com.trs.miniproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trs.miniproject.Exception.CapacityExceedException;
import com.trs.miniproject.Exception.TicketNotFound;
import com.trs.miniproject.Exception.TrainNotFound;
import com.trs.miniproject.Model.Ticket;
//import com.trs.miniproject.Exception.NumOfTicketsExceedException;
//import com.trs.miniproject.Exception.TrainNotAvailableException;
//import com.trs.miniproject.Model.Passenger;
//import com.trs.miniproject.Model.Ticket;
import com.trs.miniproject.Model.Train;
import com.trs.miniproject.Repository.TrainRepository;
import com.trs.miniproject.Repository.TicketRepository;


@Service

public class TrainService {
	@Autowired
	 private TrainRepository trainrepository;
	@Autowired
	private TicketRepository ticketrepository;

//	 public List<Train> getALlUsers() {
//	     return (List<Train>) trainrepository.findAll();
//	 }


	 public Train getTrain(int id) throws Exception {
	     Train train= trainrepository.findBytrainId(id);
	     if(train!=null){
	         return train;
	     }
	     else{
	         throw new Exception();
	     }
	 }
	 public  Train findBytrainId(Integer id) {
		 return  trainrepository.findById(id).get();
	 }


	public Train save(Train train) {

		 return trainrepository.save(train);
	}


	public List<Train> findAll() {

		 return (List<Train>) trainrepository.findAll();
	}
	public Train updateTrain(Integer id, Integer traindate) {
 
			Train train = findBytrainId(id);
			if(train.getTrainId() == id) {
				train.setTrainId(traindate);
				return trainrepository.save(train);

			}
			else 
			{
				throw new TrainNotFound();
			}
		}
	
//	public Train updateTrainCapacity(Integer id, Integer capacity) {
//		Train train = findBytrainId(id);
//        if(train.getCapacity()<=10)
//        {
//			return trainrepository.save(train);
//
//        }
//        else {
//
//			throw new CapacityExceedException();
//		
//        }
//		
//	}
//		
	}


