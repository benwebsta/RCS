package com.revature.web;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.revature.beans.Chain;
import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.service.ChainService;
import com.revature.service.GroupService;

@RestController
@RequestMapping(path="/messageRest")
public class MessageRestController {
	
	@Autowired
	ChainService chainService;
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody  String listMessageChains( 
			ModelMap modelMap, HttpSession session){
			session.setAttribute("employee", new EmployeeDaoImpl().getEmployeeById(3));
			Employee employee = (Employee) session.getAttribute("employee");
			String jsonResponse = "";
			if(employee == null){
				//employee is not logged in
				//response.sendError(403);
				return "";
			} 
			
			List<Group> groups = groupService.getGroupsContainingEmployee(employee);
			List<Chain> chains = new LinkedList<Chain>();
			groups.forEach(g -> {
				chains.addAll(chainService.getChainsByGroupOne(g));
				chains.addAll(chainService.getChainsByGroupTwo(g));
			});
			
			System.out.println(chains.size());
			jsonResponse = new Gson().toJson(chains);
			System.out.println(jsonResponse);
			
			
			return jsonResponse;
	}
	

}
