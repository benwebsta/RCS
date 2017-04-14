package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeDTO;
import com.revature.dao.ApartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.GenderDaoImpl;

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
	
	public Employee getEmployeeByUsername(String username){
		return employeeDao.getEmployeeByUsername(username);
	}
	
	public EmployeeDTO getEmployeeDTO(Employee employee){
		ApartmentDaoImpl apartmentDao = new ApartmentDaoImpl();
		GenderDaoImpl genderDao = new GenderDaoImpl();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setEmployee(employee);
		employeeDTO.setAddress(apartmentDao.getApartmentById(employee.getApartmentId()).getAddress());
		employeeDTO.setGender(genderDao.getGenderById(employee.getGenderId()));
		
		return employeeDTO;
	}
	
}
