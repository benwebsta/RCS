package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Apartment;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Apartment a = (Apartment) ac.getBean("ApartmentDaoImpl");
		
	}

}
