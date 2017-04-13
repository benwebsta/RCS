//File Name SendEmail.java
package com.revature.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.EmployeeDTO;
import com.revature.service.HRService;

@RestController
@RequestMapping("/viewEmployees")
public class ViewAllEmployeesRestController {
	
	@RequestMapping(method=RequestMethod.GET)	
	public @ResponseBody List<EmployeeDTO> viewEmployees(){
		
		HRService hrService = new HRService();
	    
		List<EmployeeDTO> employeesDTO = hrService.getAllEmployeesInHousingDTO();
		
		return employeesDTO;
	}

}