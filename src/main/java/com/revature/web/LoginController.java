package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.service.EmployeeService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	EmployeeService es;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(ModelMap modelMap) {
		return "login";
	}

}
