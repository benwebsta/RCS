package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Group;

public interface GroupDao {
	
	void addGroup(Employee...employees);
	
	List<Group> getAllGroups();
	
	Group getGroupById(int id);
	
	List<Group> getGroupsContainingEmployee(Employee employee);
	
}
