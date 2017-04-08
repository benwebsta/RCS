package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.service.TestService;

@Controller
public class TestController {
	@Autowired
	TestService testService;
	

		@RequestMapping(method=RequestMethod.GET)
		public String test(ModelMap modelMap){
			
			//modelMap.addAttribute("n", testService.getApartment());
			
			return "testPage";
		}
}
