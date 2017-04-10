package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.dao.ApartmentDao;
import com.revature.dao.ApartmentDaoImpl;

@Component
public class ApartmentService {
	ApartmentDao apartmentDao = new ApartmentDaoImpl();

	public void addNewApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		apartmentDao.addNewApartment(apartment);
	}

	public Apartment getApartmentById(int apartmentId) {
		// TODO Auto-generated method stub
		Apartment apartment = apartmentDao.getApartmentById(apartmentId);
		return apartment;
	}

	public List<Apartment> getAllApartments() {
		// TODO Auto-generated method stub
		return apartmentDao.getAllApartments();
	}

	public List<Employee> getEmployeesByApartment(int apartmentId) {
		// TODO Auto-generated method stub
		return apartmentDao.getEmployeesByApartment(apartmentId);
	}
	
}
