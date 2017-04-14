//File Name SendEmail.java
package com.revature.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeDTO;
import com.revature.service.EmployeeService;

@RestController
@RequestMapping("/getEmployeeDTO")
public class GetEmployeeDTORestController {
	
	@RequestMapping(method=RequestMethod.POST)	
	public @ResponseBody EmployeeDTO viewEmployees(@RequestBody Employee employee){
		
		EmployeeService employeeService = new EmployeeService();
	    
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO = employeeService.getEmployeeDTO(employee);
		
		return employeeDTO;
	}

}