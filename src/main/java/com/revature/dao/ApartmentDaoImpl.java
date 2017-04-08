package com.revature.dao;

import java.util.List;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;

public class ApartmentDaoImpl implements ApartmentDao{

	@Override
	public void addNewApartment(String address, String city, String state, int zipCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Apartment getApartmentById(int apartmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apartment> getAllApartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesByApartment(int apartmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGenderId(int apartmentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoomsAvailable(int apartmentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
