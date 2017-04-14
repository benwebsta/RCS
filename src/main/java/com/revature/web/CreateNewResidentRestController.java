package com.revature.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/createNewResidentRest")
public class CreateNewResidentRestController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Boolean createNewResident_JSON(@RequestBody String newResidentJson, HttpSession session, ModelMap modelMap){
		Gson gson = new Gson();
		Employee newEmployee = gson.fromJson(newResidentJson, Employee.class);
		boolean result = employeeService.updateEmployee(newEmployee);
		return result;
	}

}
