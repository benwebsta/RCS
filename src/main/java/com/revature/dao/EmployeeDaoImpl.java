package com.revature.dao;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.revature.beans.Employee;
import com.revature.config.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int employeeId) {
		Session sess = HibernateUtil.getSession();
		Employee employee = (Employee) sess.get(Employee.class, employeeId);
		sess.close();
		return employee;
	}

	@Override
	public Employee getEmployeeByLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		
		 try {
		     tx = sess.beginTransaction();
		    
			 sess.saveOrUpdate(employee);
			 
		     tx.commit();

		 }
		 catch (Exception e) {
				e.printStackTrace();

		 }
		 finally {

		     sess.close();
		 }

		 
		return true;
	}

}
