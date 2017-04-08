package com.revature.dao;

import java.util.List;

import com.revature.beans.Chain;
import com.revature.beans.Group;

public interface ChainDao {
	
	public void addNewChain(Group groupOne, Group groupTwo);
	
	public List<Chain> getAllChains();
	
	public Chain getChainById(int id);
	
	public List<Chain> getChainsByGroupOne(Group groupOne);
	
	public List<Chain> getChainsByGroupTwo(Group groupTwo);

}
