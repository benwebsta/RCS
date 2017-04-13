//File Name SendEmail.java
package com.revature.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
import com.revature.service.HRService;

@RestController
@RequestMapping("/viewEmployees")
public class ViewAllEmployeesRestController {
	
	@RequestMapping(method=RequestMethod.GET)	
	public @ResponseBody List<Employee> viewEmployees(){
		
		HRService hrService = new HRService();
	    
		List<Employee> employees = hrService.getAllEmployeesInHousing();
		
		return employees;
	}

}