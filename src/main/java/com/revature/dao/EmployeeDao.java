package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(int employeeId);

	public Employee getEmployeeByLogin(String username, String password);
	
	public boolean updateEmployee(Employee employee);

	public Employee getEmployeeByUsername(String username);
	
	public List<Employee> getAllEmployees();
	
}
