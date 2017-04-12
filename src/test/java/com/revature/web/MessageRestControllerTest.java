package com.revature.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;

import com.revature.beans.Chain;
import com.revature.beans.Employee;
import com.revature.config.RootConfig;
import com.revature.config.WebConfig;
import com.revature.service.EmployeeService;
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={WebConfig.class, RootConfig.class})
@WebAppConfiguration
@ComponentScan(basePackages = "com.revature",
excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = WebConfig.class) })
public class MessageRestControllerTest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void getAllChainsTest() throws Exception {
		
		MessageRestController mr = new MessageRestController();
		MockMvc mockMvc = standaloneSetup(mr).build();
		MockHttpSession session = new MockHttpSession();
		Employee employee = employeeService.getEmployeeById(3);
		session.setAttribute("employee", employee);
		ModelMap modelMap = new ModelMap();
		System.out.println(mockMvc.perform(get("/messageRest").session(session)).andDo(print()));
		//String json = mr.listMessageChains(modelMap, session);
		//System.out.println(json);
		
	}
}	
*/

