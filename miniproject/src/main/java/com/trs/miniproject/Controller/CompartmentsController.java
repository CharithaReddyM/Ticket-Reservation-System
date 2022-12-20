//package com.trs.miniproject.Controller;
//
////import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.trs.miniproject.Model.Compartments;
//import com.trs.miniproject.Service.CompartmentsService;
//@RestController
//@RequestMapping("/comp")
//
//
//public class CompartmentsController {
//	@Autowired
//	private CompartmentsService compartmentsservice;
//	@PostMapping("/addseat")
//	public  Compartments savecompartments(@RequestBody Compartments compartments ) {
//		return compartmentsservice.save(compartments);
//}
//	@GetMapping("/fetch-all")
//	public Compartments getAllCompartments() {
//		return (Compartments) compartmentsservice.findAll();
//		
//}
//}
