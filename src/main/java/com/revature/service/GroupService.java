package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.dao.GenderDaoImpl;
import com.revature.dao.GroupDao;
import com.revature.dao.GroupDaoImpl;

@Component
public class GroupService {

	GroupDao groupDao = new GroupDaoImpl();
	
	public List<Group> getAllGroups() {
		// TODO Auto-generated method stub
		return groupDao.getAllGroups(); 
	}

	
	public Group getGroupById(int id) {
		// TODO Auto-generated method stub
		return groupDao.getGroupById(id);
	}

	
	public List<Group> getGroupsContainingEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return groupDao.getGroupsContainingEmployee(employee);
	}

	
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		groupDao.addGroup(group);
	}
	
}
