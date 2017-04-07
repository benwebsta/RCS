package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Apartment;
import com.revature.config.HibernateUtil;

@Component
public class TestService {
	
	public TestService() {
		super();
	}


	
	public String getApartment(){
		Apartment apartment = (Apartment) HibernateUtil.getSession().get(Apartment.class, 1);
		
		return apartment.getAddress();
	}
	
	
}
