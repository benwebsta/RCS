package com.revature.dao;

import org.hibernate.Session;

import com.revature.beans.Gender;
import com.revature.config.HibernateUtil;

public class GenderDaoImpl implements GenderDao {

	@Override
	public String getGenderById(int genderId) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Gender g = (Gender) s.get(Gender.class, new Integer(genderId));
		return g != null ? g.getGender() : "";
	}

}
