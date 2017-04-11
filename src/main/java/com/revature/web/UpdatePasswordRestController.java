package com.revature.web;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@RestController
@RequestMapping("/updatePasswordRest")
public class UpdatePasswordRestController {
	EmployeeService employeeService = new EmployeeService();

	@RequestMapping(method=RequestMethod.POST)	
	/*public @ResponseBody Employee updatePassword_JSON( @RequestBody Employee employee){*/
	public @ResponseBody Boolean updatePassword_JSON( @RequestBody String employeeJson, HttpSession session, ModelMap modelMap){
		System.out.println("test");
		System.out.println(employeeJson);
		
		Employee tempEmployee = new Gson().fromJson(employeeJson, Employee.class);
		Employee employee = (Employee) session.getAttribute("employee");
		employee.setPassword(tempEmployee.getPassword());
		
		boolean result = employeeService.updateEmployee(employee);
		return result;
	}
	
}
