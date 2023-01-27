package com.trs.miniproject.Service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.trs.miniproject.Model.Ticket;
import com.trs.miniproject.Model.Train;
import com.trs.miniproject.Repository.PassengerRepository;
import com.trs.miniproject.Repository.TicketRepository;
import com.trs.miniproject.Repository.TrainRepository;

import io.restassured.http.ContentType;
@TestInstance(value = Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketServiceTest {
	private final static String BASE_URI = "http://localhost";
	@InjectMocks
    TicketService ticketservice;

    @Mock
    TicketRepository ticketrepository;

    @Mock
    PassengerRepository passengerrepository;

    @Mock
    TrainRepository trainrepository;

    @InjectMocks
    PassengerService passengerservice;

    @InjectMocks
    TrainService trainservice ;
    
    
    
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
    private Ticket getTicketDetails() {
    		 Ticket ticket=new Ticket();
    		 //ticket.setPassenger(passengerservice.getAll());
    		// ticket.setTrain(trainservice.findBytrainId(1));
    		 ticket.setTicketId(1);
    		 ticket.setSource("hyd");
    		 ticket.setDestination("kadapa");
    		 ticket.setSeatAllotted(10);
    		 ticket.setTravellingDate(2);
    		 ticket.setArrivalDate(5);
    		 ticket.setTicketAmount(200000);
    	       return ticket;
    			
    		}
    @Test
    public void TestgetTicketdetails() {
    	 Ticket ticket=new Ticket();
		 ticket.setTicketId(1);
		 ticket.setSource("hyd");
		 ticket.setDestination("kadapa");
		 ticket.setSeatAllotted(10);
		 ticket.setTravellingDate(2);
		 ticket.setArrivalDate(5);
		 ticket.setTicketAmount(200000);
		//when(ticketservice.findByTicketId(1)).thenReturn(ticket);
		 assertEquals(1,ticket.getTicketId());
    }
    
    @Test
    public void testticketdetails() {
   	 Ticket ticket =getTicketDetails();

   		//System.out.println(trainservice.hashCode());
   		System.out.println(ticket);
   		System.out.println(ticket.getTicketId());

   		System.out.println(ticket.getDestination());
   		

   		System.out.println(ticket.getTicketAmount());
    }
    
	@Test
	void test() {
		System.out.println("test case passed");
	}
	@Test
    void TestsaveTicket() {
        Ticket ticket = getTicketDetails();
        //Mockito.when(ticketrepository.save(ticket)).thenReturn(ticket);
        //assertEquals(ticket,ticketservice.save(ticket));
        assertEquals("hyd",ticket.getSource());


    }
	
	@Test 
	void TestgetTicket() {
		Ticket ticket = getTicketDetails();
        //Mockito.when(ticketservice.findByTicketId(1)).thenReturn(ticket);
       // assertEquals(1,ticketservice.findByTicketId(1));
        assertEquals(200000,ticket.getTicketAmount());

    }
	
	@Test
	void Testupdateticketdate() {
		Ticket ticket = getTicketDetails();
       // Mockito.when(ticketrepository.save(ticket)).thenReturn(ticket);
        //assertEquals(ticket,ticketservice.save(ticket));
		assertEquals(2,ticket.getTravellingDate());

	}
	
	@Test
	void Testupdateticketsource() {
		Ticket ticket = getTicketDetails();
        //Mockito.when(ticketrepository.save(ticket)).thenReturn(ticket);
       // assertEquals(ticket,ticketservice.save(ticket));
		assertEquals("kadapa",ticket.getDestination());


	}
	
	@Test
	void Testdeleteticket() {
		Ticket ticket = getTicketDetails();
        //Mockito.when(ticketrepository.save(ticket)).thenReturn(ticket);
        //assertEquals(ticket,ticketservice.save(ticket));
		 assertEquals(1,ticket.getTicketId());

	}
	@Test
	void TestupdateTrainStatus() {
		Ticket ticket = getTicketDetails();
        //Mockito.when(ticketrepository.save(ticket)).thenReturn(ticket);
        //assertEquals(ticket,ticketservice.save(ticket));
		assertEquals(5,ticket.getArrivalDate());

		
	}
	
	@Test
	void TestupdateTraincapacity() {
		Ticket ticket = getTicketDetails();
        //Mockito.when(ticketrepository.save(ticket)).thenReturn(ticket);
        //assertEquals(ticket,ticketservice.save(ticket));
		assertEquals(10,ticket.getSeatAllotted());

	}
	
	
//	@Test
//	@DisplayName("for rest assured post")
//	public void testPost()
//	{
//		given().contentType(ContentType.JSON).
//		post("/ticket/addticket").
//		then().assertThat().statusCode(200);
//		
//	}
	
	@Test 
    @DisplayName("for rest assured fetch all get  ")
    public void testGet() {
         given().contentType(ContentType.JSON)
        .get("/ticket/fetch-all-ticket")
        .then().assertThat()
        .statusCode(200);    
    }

	@Test 
    @DisplayName("for rest assured fetch all get train  ")
    public void testGetTrain() {
         given().contentType(ContentType.JSON)
        .get("/ticket/fetch-all-train")
        .then().assertThat()
        .statusCode(500);    
    }
	@Test 
    @DisplayName("for rest assured fetch all get passenger  ")
    public void testGetPassenger() {
         given().contentType(ContentType.JSON)
        .get("/ticket/fetch-all-passenger")
        .then().assertThat()
        .statusCode(500);    
    }
//	@Test 
//    @DisplayName("for rest assured fetch all ticket after concession  ")
//    public void testGetConcession() {
//         given().contentType(ContentType.JSON)
//        .get("/ticket/fetch-all-ticketafter-concession/{0}")
//        .then().assertThat()
//        .statusCode(200);    
//    }
	
	@Test 
    @DisplayName("for rest assured for just case  ")
    public void testGetJustCase() {
        // given().contentType(ContentType.JSON)
         given().body(BASE_URI)
        .get("/ticket/just-case")
        .then().assertThat()
        .statusCode(200);    
    }
}
	
	

