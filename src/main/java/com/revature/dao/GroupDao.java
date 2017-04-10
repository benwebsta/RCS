package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Group;

public interface GroupDao {
	
	void addGroup(Group group);
	
	List<Group> getAllGroups();
	
	Group getGroupById(int id);
	
	List<Group> getGroupsContainingEmployee(Employee employee);
	
}
