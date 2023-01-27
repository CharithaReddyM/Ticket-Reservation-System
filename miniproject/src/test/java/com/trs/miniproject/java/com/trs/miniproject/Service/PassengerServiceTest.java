package com.trs.miniproject.Service;


import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
//import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.trs.miniproject.Model.Passenger;
import io.restassured.response.Response;
//@ExtendWith(value = { MockitoExtension.class })
@TestInstance(value = Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PassengerServiceTest {
	private final static String BASE_URI = "http://localhost";
//	@Mock
//	private PassengerRepository passengerrepository;
//
//	@InjectMocks	
//	private PassengerService passengerservice;
	private final ObjectMapper objectMapper= new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@LocalServerPort
    private int port;
//	@BeforeEach
//    void init() {
//        MockitoAnnotations.initMocks(this);
//    }
	@BeforeEach
    public void setUp() {
     baseURI = BASE_URI;
     port = this.port;
    }
	@DisplayName("passenger test")
	@Test
     private Passenger getPassenger() {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setPassengerAge(22);
		passenger.setPassengerName("charitha");
		
		return passenger;
	}
	
  @Test
	void testFindByPassengerId() {
	      Passenger passenger = getPassenger();
    //  when(passengerservice.findBypassengerId(1)).thenReturn(passenger);
		//assertEquals(passenger, passengerservice.getClass());
		assertEquals(22, passenger.getPassengerAge());
	}
	@Test
	
	public void testpassengerdetails() {
		Passenger passenger =getPassenger();

		//System.out.println(passengerservice.hashCode());
		System.out.println(passenger.getPassengerId());
		System.out.println(passenger.getPassengerName());
		System.out.println(passenger.getPassengerAge());	

	 }
	
	
	
//	@Test
//    @DisplayName("Test for save all  method")
//    void TestsaveAll() {
//        List<Passenger> passenger = new ArrayList<Passenger>();
//        Mockito.when(passengerservice.saveAll(passenger)).thenReturn((Passenger) passenger);
//        assertEquals(passenger,passengerservice.saveAll(passenger));
//    }
//	@Test
//    @DisplayName("Test for save all  method")
//    void TestsaveAll() {
//        List<Passenger> passenger = new ArrayList<Passenger>();
//        Mockito.when(((PassengerRepository) passengerservice).save(passenger)).thenReturn(passenger);
//        assertEquals(passenger,passengerservice.saveAll(passenger));
//        
//    }
	@Test
	@DisplayName("test for passenger")
	void test1() {
		Passenger passenger=getPassenger();
		//System.out.println(passengerservice.hashCode());

		System.out.println("test case passed");
		System.out.println(passenger);

	}
	
	@Test 
    @DisplayName("for rest assured fetch all get  ")
    public void testGet() {
         given().contentType(ContentType.JSON)
        .get("/passenger/fetch-all")
        .then().assertThat()
        .statusCode(200);    
    }
	
	@Test
	@DisplayName("for rest assured")
	void tessssst() {
		//Response code=get("http://www.google.com");
		  
		 // System.out.println(code.getStatusCode());
		  given().when().get("http://www.google.com").then().statusCode(200);
		  
	}
	
//	@Test
//	@DisplayName("for rest assured post")
//	public void testPost()
//	{
//		given().contentType(ContentType.JSON).
//		post("/passenger/addPassenger").
//		then().assertThat().statusCode(200);
//		
//	}
}
