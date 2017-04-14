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
@RequestMapping("/moveEmployeeOut")
public class MoveEmployeeOutRestController {
	EmployeeService employeeService = new EmployeeService();

	@RequestMapping(method=RequestMethod.POST)	
	public @ResponseBody Boolean moveOut_JSON( @RequestBody String employeeJson, HttpSession session, ModelMap modelMap){
		
		Employee employee = new Gson().fromJson(employeeJson, Employee.class);
		boolean result = employeeService.updateEmployee(employee);
		
		return true;
	}
	
}
