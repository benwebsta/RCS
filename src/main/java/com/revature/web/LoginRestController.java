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
@RequestMapping("/loginRest")
public class LoginRestController {
	
	EmployeeService employeeService = new EmployeeService();
	
	@RequestMapping(method=RequestMethod.POST)	
	/*public @ResponseBody Employee updatePassword_JSON( @RequestBody Employee employee){*/
	public @ResponseBody String login_JSON( @RequestBody String[] credentials, ModelMap modelMap, HttpSession session){
		System.out.println("test");
		System.out.println(credentials);
		Employee employee = employeeService.loginEmployee(credentials[0], credentials[1]);
		modelMap.addAttribute("employee", employee);
		session.setAttribute("employee", employee);
		
		if (modelMap.containsAttribute("employee"))
			System.out.println(employee);
		if (session.getAttribute("employee") != null)
			System.out.println(employee);
		
		System.out.println("end of login rest controller");
		String employeeJson = new Gson().toJson(employee);
		return employeeJson;
	}

}
