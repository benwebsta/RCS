package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.beans.Message;
import com.revature.config.HibernateUtil;

public class GroupDaoImpl implements GroupDao {

	@Override
	public List<Group> getAllGroups() {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		List<Group> groupList;
		groupList = sess.createCriteria(Group.class).list();
		return groupList;
	}

	@Override
	public Group getGroupById(int id) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Group group = (Group) sess.get(Group.class, id);
		sess.close();
		return group;
	}

	@Override
	public List<Group> getGroupsContainingEmployee(Employee employee) {
		Session sess = HibernateUtil.getSession();
		List<Group> groups = null;
		Criteria c = sess.createCriteria(Group.class);
		if (employee != null){
			SimpleExpression c1 = Restrictions.eq("employee1", employee);
			SimpleExpression c2 = Restrictions.eq("employee2", employee);
			SimpleExpression c3 = Restrictions.eq("employee3", employee);
			SimpleExpression c4 = Restrictions.eq("employee4", employee);
			SimpleExpression c5 = Restrictions.eq("employee5", employee);
			SimpleExpression c6 = Restrictions.eq("employee6", employee);
			
			LogicalExpression le = Restrictions.or(c1, c2);
			le = Restrictions.or(le, c3);
			le = Restrictions.or(le, c4);
			le = Restrictions.or(le, c5);
			le = Restrictions.or(le, c6);
			c.add(le);
			groups = c.list();
		}
		return groups;
	}

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		try
		{
			tx = sess.beginTransaction();
			sess.saveOrUpdate(group);
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

}
