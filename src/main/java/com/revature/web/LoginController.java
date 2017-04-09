package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Employee;
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

	@RequestMapping(method = RequestMethod.POST, path="/login")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, HttpSession session){
		Employee authEmp = es.loginEmployee(request.getParameter("username"), request.getParameter("password"));
		System.out.println(authEmp);
		if (authEmp != null) {
			System.out.println(authEmp.getUsername());
			modelMap.addAttribute("employee", authEmp);
			session.setAttribute("employee", authEmp);
			return "home";
		}
		else {
			modelMap.addAttribute("errorMessage", "Username/password invalid");
			return "login";
		}
	}

}
