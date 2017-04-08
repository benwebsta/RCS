package com.revature.service;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDaoImpl();

	public Employee loginEmployee(String username, String password){
		
		return null;
	}
	
	public Employee getEmployeeById(int employeeId){
		Employee employee = employeeDao.getEmployeeById(employeeId);
		return employee;
	}
	
	public boolean updateEmployee(Employee employee){
		employeeDao.updateEmployee(employee);
		return true;
	}
	
}
