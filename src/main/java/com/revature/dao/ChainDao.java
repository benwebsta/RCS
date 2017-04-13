package com.revature.dao;

import java.io.Serializable;
import java.util.List;

import com.revature.beans.Chain;
import com.revature.beans.Group;

public interface ChainDao {
	
	public Integer addNewChain(Chain chain);
	
	public List<Chain> getAllChains();
	
	public Chain getChainById(int id);
	
	public List<Chain> getChainsByGroupOne(Group groupOne);
	
	public List<Chain> getChainsByGroupTwo(Group groupTwo);

}
