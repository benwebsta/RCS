package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.dao.ApartmentDao;
import com.revature.dao.ApartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

@Component
public class HRService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	ApartmentDao apartmentDao = new ApartmentDaoImpl();
	
	public boolean transferEmployeeToApt(Employee emp, Apartment apt){
		System.out.println("old employees in apartment: " + apt.getEmployees());
		if(apartmentDao.getRoomsAvailable(apt.getApartmentId()) == 0)
			return false;
		else {
			List<Employee> employeeList = apt.getEmployees();
			employeeList.add(emp);
			apt.setEmployees(employeeList);
			System.out.println("new employees in apt: " + apt.getEmployees() );
			return apartmentDao.updateApartment(apt);
		}
	}

}
