package com.revature.dao;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(int employeeId);

	public Employee getEmployeeByLogin(String username, String password);
	
	public boolean updatePassword(int employeeId, String newPassword);
	
}
