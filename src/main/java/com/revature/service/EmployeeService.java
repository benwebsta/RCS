package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

@Component
public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDaoImpl();

	public Employee loginEmployee(String username, String password){
		
		return employeeDao.getEmployeeByLogin(username, password);
	}
	
	public Employee getEmployeeById(int employeeId){
		Employee employee = employeeDao.getEmployeeById(employeeId);
		return employee;
	}
	
	public boolean updateEmployee(Employee employee){
		return employeeDao.updateEmployee(employee);
	}
	
}
