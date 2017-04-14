package com.revature.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Apartment;
import com.revature.service.ApartmentService;

@RestController
@RequestMapping("/viewApartments")
public class ViewAllApartmentsRestController {
	
	@RequestMapping(method=RequestMethod.GET)	
	public @ResponseBody List<Apartment> viewApartments(){
		
		ApartmentService aptService = new ApartmentService();
	    
		List<Apartment> apartments = aptService.getAllApartments();

		return apartments;
	}
}
