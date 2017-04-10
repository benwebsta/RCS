package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.beans.Group;
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
		// TODO Auto-generated method stub
		return null;
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
