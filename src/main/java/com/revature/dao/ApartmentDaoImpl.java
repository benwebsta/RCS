package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.config.HibernateUtil;

public class ApartmentDaoImpl implements ApartmentDao{

	//This method just saves the information passed in from the front-end
	//pertaining to adding a new apartment
	@Override
	public void addNewApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		try
		{
			tx = sess.beginTransaction();
			sess.saveOrUpdate(apartment);
			tx.commit();
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			sess.close();
		}
	}
	
	//Returns an apartment object by the apartmentID
	@Override
	public Apartment getApartmentById(int apartmentId) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Apartment apartment = (Apartment) sess.get(Apartment.class, apartmentId);
		sess.close();
		return apartment;
	}
	
	//Returns all apartments that are currently in the apartment list
	@Override
	public List<Apartment> getAllApartments() {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		List<Apartment> aptList;
		aptList = sess.createCriteria(Apartment.class).list();
		return aptList;
	}

	//Returns a list of employees that are currently residing in a certain apartment
	@Override
	public List<Employee> getEmployeesByApartment(int apartmentId) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Apartment apartment = (Apartment) sess.get(Apartment.class, apartmentId);
		List<Employee> empList;
		empList = apartment.getEmployees();
		sess.close();
		return empList;
	}

	//Returns the genderID of a certain apartment
	@Override
	public int getGenderId(int apartmentId) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Apartment apartment = (Apartment) sess.get(Apartment.class, apartmentId);
		int genderID;
		genderID = apartment.getGenderId();
		sess.close();
		return genderID;
	}

	//Returns the available number of rooms for a certain apartment
	@Override
	public int getRoomsAvailable(int apartmentId) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Apartment apartment = (Apartment) sess.get(Apartment.class, apartmentId);
		int roomsAvailable;
		roomsAvailable = apartment.getRoomsAvailable();
		sess.close();
		return roomsAvailable;
	}
	
	@Override
	public boolean updateApartment(Apartment apartment) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		
		 try {
		     tx = sess.beginTransaction();
		    
			 sess.merge(apartment);
			 
		     tx.commit();
		     return true;

		 }
		 catch (Exception e) {
				e.printStackTrace();
				return false;
		 }
		 finally {

		     sess.close();
		 }
	}

}
