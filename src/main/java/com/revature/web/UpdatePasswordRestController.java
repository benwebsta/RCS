package com.revature.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@RestController
public class UpdatePasswordRestController {
	EmployeeService employeeService = new EmployeeService();


	@RequestMapping(value = "updatePassword_json", method=RequestMethod.POST)	
	public @ResponseBody String updatePassword_JSON( @RequestBody Employee employee){
		System.out.println("test");
		System.out.println(employee);
		/*employeeService.updateEmployee(employee);*/
		return "updatePassword";
	}
	
}
