package com.trs.miniproject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
	@ExceptionHandler(value=PassengerNotFound.class)
    public ResponseEntity<Object> exception(PassengerNotFound exception){
        return new ResponseEntity<>("Passenger does not exist",HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(value=NumOfTicketsExceedException.class)
    public ResponseEntity<Object> exception1(NumOfTicketsExceedException exception){
        return new ResponseEntity<>("tickets should not be more than 3",HttpStatus.NOT_FOUND);
        
}
	@ExceptionHandler(value=TicketNotFound.class)
    public ResponseEntity<Object> exception2(TicketNotFound exception){
        return new ResponseEntity<>("ticket not found",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=TrainNotFound.class)
    public ResponseEntity<Object> exception3(TrainNotFound exception){
        return new ResponseEntity<>("train not found",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=TicketIdUniqueException.class)
    public ResponseEntity<Object> exception4(TicketIdUniqueException exception){
        return new ResponseEntity<>("ticked id should be unique",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=CapacityExceedException.class)
    public ResponseEntity<Object> exception5(CapacityExceedException exception){
        return new ResponseEntity<>("no.of seet capacity should not exceed 10",HttpStatus.NOT_FOUND);
}
}