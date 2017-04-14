package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeDTO;
import com.revature.dao.ApartmentDao;
import com.revature.dao.ApartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.GenderDao;
import com.revature.dao.GenderDaoImpl;

@Component
public class HRService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	ApartmentDao apartmentDao = new ApartmentDaoImpl();
	GenderDao genderDao = new GenderDaoImpl();
	
	public List<Employee> getAllEmployeesInHousing(){
		List<Employee> employees = employeeDao.getAllEmployees();
		employees.removeAll(employees);
		
		List<Employee> tempEmployees = employeeDao.getAllEmployees();
		
		System.out.println(tempEmployees);
		
		for(Employee employee : tempEmployees){
			if(employee.getFill() == 1){
				employees.add(employee);
			}
		}
		return employees;
	}
	
	public List<EmployeeDTO> getAllEmployeesInHousingDTO(){
		List<Employee> employees = getAllEmployeesInHousing();
		List<EmployeeDTO> employeesDTO = new ArrayList<EmployeeDTO>();
		
		for(Employee employee : employees){
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployee(employee);
			employeeDTO.setAddress(apartmentDao.getApartmentById(employee.getApartmentId()).getAddress());
			employeeDTO.setGender(genderDao.getGenderById(employee.getGenderId()));
			
			employeesDTO.add(employeeDTO);
			
			employeeDTO = null;
		}
		System.out.println(employeesDTO);
		
		return employeesDTO;
	}
	


}
