package com.revature.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.beans.Apartment;
import com.revature.config.HibernateUtil;

public class ApartmentDaoTest {

	
	@BeforeClass
	public static void setUpHibernate(){
		Session session = HibernateUtil.getSession();
		assertNotNull(session);
		System.out.println(session);
	}
	
	@Test
	public void test(){
		
	}
	
	
	@Ignore
	@Test
	public void addNewApartment(){
		ApartmentDao apartmentDao = new ApartmentDaoImpl();
		
		Apartment apartment = new Apartment();
		apartment.setAddress("1234 test dr");
		apartment.setCity("Reston");
		apartment.setState("VA");
		apartment.setRoomsAvailable(3);
		apartment.setZipCode(12345);
		apartment.setGenderId(1);
		
		
		int s = apartmentDao.getAllApartments().size();
		apartmentDao.addNewApartment(apartment);
		assertEquals(s+1, apartmentDao.getAllApartments().size());
	}
	
	
}
