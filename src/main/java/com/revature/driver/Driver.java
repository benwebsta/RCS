package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeService employeeService = new EmployeeService();
		
		Employee employee = employeeService.getEmployeeById(1);
		
		employee.setPassword("testuuuuu");
		employeeService.updateEmployee(employee);
		
		
	}

}
