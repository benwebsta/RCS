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
	


}
