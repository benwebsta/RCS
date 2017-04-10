package com.revature.service;

import java.util.List;

import com.revature.beans.Chain;
import com.revature.beans.Group;
import com.revature.dao.ChainDao;
import com.revature.dao.ChainDaoImpl;

public class ChainService {
	ChainDao chainDao = new ChainDaoImpl();
	
	public List<Chain> getAllChains() {
		// TODO Auto-generated method stub
		return chainDao.getAllChains();
	}

	
	public Chain getChainById(int id) {
		// TODO Auto-generated method stub
		Chain chain = chainDao.getChainById(id);
		return chain;
	}

	
	public List<Chain> getChainsByGroupOne(Group groupOne) {
		// TODO Auto-generated method stub
		return chainDao.getChainsByGroupOne(groupOne);
	}

	
	public List<Chain> getChainsByGroupTwo(Group groupTwo) {
		// TODO Auto-generated method stub
		return chainDao.getChainsByGroupTwo(groupTwo);
	}

	
	public void addNewChain(Chain chain) {
		// TODO Auto-generated method stub
		chainDao.addNewChain(chain);
	}
}
