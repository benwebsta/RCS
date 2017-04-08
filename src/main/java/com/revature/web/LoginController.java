package com.revature.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@Controller
//if you get a request for /login, this is where it goes
@RequestMapping(value = "/")
public class LoginController {
	// if you want to forward to a page return string
	// "forward:resources/htmlPage.html"
	// also "redirect: etc.
	
	@Autowired
	Employee emptyEmp;
	
	@Autowired
	EmployeeService employeeService;
	
	// adding info to the model
	// param name is someInfo
	@ModelAttribute("someInfo")
	public String addInfoToRequestScope(){
		
		System.out.println("adding something to the modelmap");
		return "This is the information added";
	}
	
	// method would be an http method
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap) {
		
		System.out.println(modelMap.get("someInfo"));
		System.out.println("This was a get request");
		modelMap.addAttribute("employee", emptyEmp);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	
	// @Valid checks with validation tags in spring that input is a valid object
	public String doLogin(@Valid Employee emp, BindingResult bindingResult, ModelMap modelMap, HttpSession session){
		System.out.println("This was a post request");
		if(bindingResult.hasErrors()){
			return "login";
		}
		// loginEmployee(Employee) doesn't exist
		Employee authEmp = employeeService.loginEmployee(emp);
		if (authEmp != null) {
			System.out.println(emp.getUsername());
			modelMap.addAttribute("employee", emp);
			session.setAttribute("alsoEmp", emp);
			return "home";
		}
		else {
			modelMap.addAttribute("errorMessage", "Username/password invalid");
			return "login";
		}
	}

}
