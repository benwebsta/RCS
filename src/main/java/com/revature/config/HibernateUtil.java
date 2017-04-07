package com.revature.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


public class HibernateUtil {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}