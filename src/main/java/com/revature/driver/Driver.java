package com.revature.driver;

import java.util.LinkedList;
import java.util.List;

import org.springframework.util.SystemPropertyUtils;

import com.google.gson.Gson;
import com.revature.beans.Chain;
import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.dao.ChainDao;
import com.revature.dao.ChainDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.GroupDao;
import com.revature.dao.GroupDaoImpl;
import com.revature.service.ChainService;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		GroupDao groupDao = new GroupDaoImpl();
		
		Employee e = employeeDao.getEmployeeById(3);
		List<Group> g = groupDao.getGroupsContainingEmployee(e);
		ChainDao chainDao = new ChainDaoImpl();
		
		List<Chain> chains = new LinkedList<>();
		for(Group g2 : g){
		chains.addAll(chainDao.getChainsByGroupOne(g2));
		chains.addAll(chainDao.getChainsByGroupTwo(g2));
		}
		String json = new Gson().toJson(chains);
		System.out.println(g.size());
		System.out.println(chains.size());
		System.out.println(json);
		
	}

}
