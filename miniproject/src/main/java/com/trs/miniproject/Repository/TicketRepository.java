package com.trs.miniproject.Repository;
import org.springframework.data.repository.CrudRepository;

import com.trs.miniproject.Model.Ticket;
public interface TicketRepository extends CrudRepository<Ticket, Integer>  {

	Ticket findByticketId(int id);







}
