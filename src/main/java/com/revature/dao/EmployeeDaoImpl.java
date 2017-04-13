package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

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
		Employee returnEmployee = null;
		Session sess = HibernateUtil.getSession();
		Criteria cr = sess.createCriteria(Employee.class);
		Criterion authUsername = Restrictions.eq("username", username);
		Criterion authPassword = Restrictions.eq("password", password);
		LogicalExpression lg = Restrictions.and(authUsername, authPassword);
		cr.add(lg);
		List<Employee> employeeList = cr.list();
		for(Employee employee : employeeList) {
			returnEmployee = employee;
		}
		
		sess.close();
		return returnEmployee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		
		 try {
		     tx = sess.beginTransaction();
		    
			 sess.saveOrUpdate(employee);
			 
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

	@Override
	public Employee getEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Criteria c = sess.createCriteria(Employee.class);
		c.add(Restrictions.eq("username", username));
		List<Employee> l = c.list();
		return l.size() == 1 ? l.get(0) : null; 
	}
	
	public List<Employee> getAllEmployees(){
		Session sess = HibernateUtil.getSession();
		List<Employee> employees = sess.createCriteria(Employee.class).list();
		return employees;
	}

}
