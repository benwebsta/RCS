package com.revature.dao;

import java.util.List;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;

public interface ApartmentDao {

	public void addNewApartment(Apartment apartment);
	
	public Apartment getApartmentById(int apartmentId);
	
	public List<Apartment> getAllApartments();
	
	public List<Employee> getEmployeesByApartment(int apartmentId);
	
	public int getGenderId(int apartmentId);
	
	public int getRoomsAvailable(int apartmentId);
	
}
