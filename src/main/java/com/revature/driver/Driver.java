package com.revature.driver;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.dao.ApartmentDao;
import com.revature.dao.ApartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.service.HRService;

public class Driver {

	public static void main(String[] args) {
		HRService hs = new HRService();
		EmployeeDao eDao = new EmployeeDaoImpl();
		ApartmentDao aDao = new ApartmentDaoImpl();
		Employee e = eDao.getEmployeeById(3);
		Apartment a = aDao.getApartmentById(2);
		System.out.println(e);
		System.out.println(a);
		
		hs.transferEmployeeToApt(e, a);
		System.out.println("finished");
	}

}
