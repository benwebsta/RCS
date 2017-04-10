package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
		List<Chain> chain = (List<Chain>) sess.get(Chain.class, groupOne);
		sess.close();
		return chain;
	}

	@Override
	public List<Chain> getChainsByGroupTwo(Group groupTwo) {
		// TODO Auto-generated method stub
		Session sess = HibernateUtil.getSession();
		List<Chain> chain = (List<Chain>) sess.get(Chain.class, groupTwo);
		sess.close();
		return chain;
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
