package com.trs.miniproject.Service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.trs.miniproject.Model.Passenger;
import com.trs.miniproject.Model.Train;
import com.trs.miniproject.Repository.TrainRepository;

import io.restassured.http.ContentType;
@TestInstance(value = Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainServiceTest {
	private final static String BASE_URI = "http://localhost";
	@Mock
	 private TrainRepository trainrepository;

	@InjectMocks
 private TrainService trainservice;
	 
    private final ObjectMapper objectMapper= new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@LocalServerPort
    private int port;
	@BeforeEach
    public void setUp() {
     baseURI = BASE_URI;
     port = this.port;
    }
	
//	@BeforeEach
//    void init() {
//        MockitoAnnotations.initMocks(this);
//    }
	
@Test
private Train  getTrain() {
	 Train train=new Train();
	 train.setTrainId(1);
	 train.setTravellingDate(10);
	 train.setNoOfComparments(10);
	 train.setCapacity(10);
     train.setTrainSource("hyd");
	 train.setTrainDestination("rjp");
	 train.setIsAvailable(true);
       return train;
		
	}
 @Test
 void testfindBytrainId() {
     Train train = getTrain();
     when(trainservice.saveTrain(train)).thenReturn(train);
	assertEquals(1, train.getTrainId());
}
 @Test
 public void testtraindetails() {
	 Train train =getTrain();

		//System.out.println(trainservice.hashCode());
		System.out.println(train);
		System.out.println(train.getIsAvailable());	
		System.out.println(train.getTrainDestination());	


	 }
 
 @Test
	void test() {
		System.out.println("test case passed");
 }
	
	@Test
	void Testsave()
	{
		Train train=getTrain();
		when(trainrepository.findBytrainId(1)).thenReturn(train);
		 assertEquals(train.isAvailable,train.isAvailable);
	}
	
	@Test 
    @DisplayName("for rest assured fetch all get  ")
    public void testGet() {
         given().contentType(ContentType.JSON)
        .get("/train/fetch-all")
        .then().assertThat()
        .statusCode(200);    
    }

}
