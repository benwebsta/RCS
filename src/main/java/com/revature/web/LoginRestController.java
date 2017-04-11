package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@RestController
@RequestMapping("/login")
public class LoginRestController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public @ResponseBody String getUser(@PathVariable("id") int id) {
		System.out.println("fetching user with id" + id);
        Employee emp = employeeService.getEmployeeById(id);
        if (emp == null) {
            System.out.println("uid not found" + id);
        }
		return "login";
	}

}
