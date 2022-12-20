package com.trs.miniproject.Repository;


import org.springframework.data.repository.CrudRepository;

import com.trs.miniproject.Model.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

	Passenger findBypassengerId(int id);

	

}
