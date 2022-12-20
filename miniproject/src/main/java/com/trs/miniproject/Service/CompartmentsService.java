//package com.trs.miniproject.Service;
//
////import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//
////import com.trs.miniproject.Exception.NumOfTicketsExceedException;
//import com.trs.miniproject.Exception.SeatsExceedException;
//import com.trs.miniproject.Repository.CompartmentsRepository;
////import com.trs.miniproject.Model.Passenger;
//@Service
//public class CompartmentsService {
//	  @Autowired
//	  private CompartmentsRepository compartmentsrepository ;
//	  public Compartments save(Compartments compartments) {
//
//			return compartmentsrepository.save(compartments);
//		}
//
//	  public Compartments findAll() {
//			
//			return (Compartments) compartmentsrepository.findAll();
//		}
//	  public void check(int id) {
//		  Compartments compartments = findByNumOsSeats(id);
//			if(compartments.getSeats()<=10)
//			{
//			 compartments.getSeats();
//			}
//			else {
//				throw new SeatsExceedException();
//			}
//		}
//
//	private Compartments findByNumOsSeats(int id) {
//
//		return  compartmentsrepository.findBycompartmentsId(id);
//	}
//
//
//}
