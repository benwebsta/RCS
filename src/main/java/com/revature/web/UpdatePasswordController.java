package com.revature.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@Controller
@RequestMapping("/updatePassword")
public class UpdatePasswordController {
	EmployeeService employeeService = new EmployeeService();

		@RequestMapping(method=RequestMethod.GET)
		public String test(ModelMap modelMap){
			
			
			return "updatePassword";
		}
		
/*		@RequestMapping(method=RequestMethod.POST)
		public @ResponseBody String updatePassword_JSON( @RequestBody Employee employee){
			System.out.println("test");
			System.out.println(employee);
			employeeService.updateEmployee(employee);
			return "updatePassword";
		}*/

}
