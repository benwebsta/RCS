package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Apartment;
import com.revature.beans.Chain;
import com.revature.beans.Group;
import com.revature.config.HibernateUtil;

public class ChainDaoImpl implements ChainDao {

	//Returns a list that contains all current chains
	@Override
	public List<Chain> getAllChains() {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		List<Chain> chainList;
		chainList = sess.createCriteria(Chain.class).list();
		return chainList;
	}

	//Returns a specific chain based on id
	@Override
	public Chain getChainById(int id) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Chain chain = (Chain) sess.get(Chain.class, id);
		sess.close();
		return chain;
	}

	@Override
	public List<Chain> getChainsByGroupOne(Group groupOne) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Criteria c = sess.createCriteria(Chain.class);
		c.add(Restrictions.eq("group1", groupOne));
		List<Chain> chains = c.list();
		//List<Chain> chain = (List<Chain>) sess.get(Chain.class, groupOne);
		sess.close();
		return chains;
	}

	@Override
	public List<Chain> getChainsByGroupTwo(Group groupTwo) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Criteria c = sess.createCriteria(Chain.class);
		c.add(Restrictions.eq("group2", groupTwo));
		List<Chain> chains = c.list();
		//List<Chain> chain = (List<Chain>) sess.get(Chain.class, groupTwo);
		sess.close();
		return chains;
	}

	@Override
	public void addNewChain(Chain chain) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		try
		{
			tx = sess.beginTransaction();
			sess.saveOrUpdate(chain);
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
