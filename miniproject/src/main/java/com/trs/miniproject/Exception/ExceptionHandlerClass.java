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
        return new ResponseEntity<>("no.of seats capacity should not exceed 10",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=SourceException.class)
    public ResponseEntity<Object> exception6(SourceException exception){
        return new ResponseEntity<>("source should not be empty",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=DestinationException.class)
    public ResponseEntity<Object> exception7( DestinationException exception){
        return new ResponseEntity<>("destination should not be empty",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=SeatsAllotedException.class)
    public ResponseEntity<Object> exception8( SeatsAllotedException exception){
        return new ResponseEntity<>("seats should not be negative",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=ArrivalDateException.class)
    public ResponseEntity<Object> exception8( ArrivalDateException exception){
        return new ResponseEntity<>("date should not be negative",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=TravellingDateException.class)
    public ResponseEntity<Object> exception9( TravellingDateException exception){
        return new ResponseEntity<>("date should not be negative",HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(value=PassengerException.class)
    public ResponseEntity<Object> exception10(  PassengerException exception){
        return new ResponseEntity<>("passenger details should not be empty",HttpStatus.NOT_FOUND);
}

	@ExceptionHandler(value=TrainIdException.class)
    public ResponseEntity<Object> exception11(TrainIdException   exception){
        return new ResponseEntity<>("train id should be positive",HttpStatus.NOT_FOUND);
}
}