package com.revature.web;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.dao.GroupDao;
import com.revature.service.GroupService;

@Ignore("To be removed when Group Service is ready to test")
public class GroupServiceTest {
	
	@InjectMocks
	GroupService groupService;
	
	@Mock
	GroupDao mockDao;
	
	List<Group> groups;
	
	Employee employee1 = new Employee();
	Employee employee2 = new Employee();
	Employee employee3 = new Employee();
	Employee employee4 = new Employee();
	Employee employee5 = new Employee();
	
	@Before
	public void setUp (){
		MockitoAnnotations.initMocks(mockDao);
		
		setUpExistingData();
		mockAddGroup();
		mockGetAllGroups();
		mockGetGroupById();
		mockGetGroupContainingEmployee();
		
	}

	private void mockGetGroupContainingEmployee() {
		Answer<List<Group>> groupsToAnswer = new Answer<List<Group>>(){

			@Override
			public List<Group> answer(InvocationOnMock invocation) throws Throwable {
				Employee employee = invocation.getArgument(1);
				
				List<Group> list = new LinkedList<Group>();
				for(Group group: groups){
					int id = employee.getEmployeeId();
					if ((group.getEmployee1() != null && group.getEmployee1().getEmployeeId() == id)
							|| (group.getEmployee2() != null && group.getEmployee2().getEmployeeId() == id)
							|| (group.getEmployee3() != null && group.getEmployee3().getEmployeeId() == id)
							|| (group.getEmployee4() != null && group.getEmployee4().getEmployeeId() == id)
							|| (group.getEmployee5() != null && group.getEmployee5().getEmployeeId() == id)
							|| (group.getEmployee6() != null && group.getEmployee6().getEmployeeId() == id)
							){
						list.add(group);
					}	
				}	
				return list;
			}
		};
		
		doAnswer(groupsToAnswer).when(mockDao).getGroupsContainingEmployee(any(Employee.class));		
	}

	private void mockGetGroupById() {
		when(mockDao.getGroupById(anyInt())).thenReturn(null);
		
		for(Group group : groups){
			when(mockDao.getGroupById(group.getGroupId())).thenReturn(group);
		}
	}

	private void mockGetAllGroups() {
		when(mockDao.getAllGroups()).thenReturn(groups);
		
	}

	private void mockAddGroup() {
		Answer<Void> addGroupAnswer = new Answer<Void>(){

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Group newGroup = new Group();
				newGroup.setGroupId(new Random().nextInt());
				Employee[] employees = invocation.getArgument(1);
				if (employees.length >= 1){
					newGroup.setEmployee1(employees[0]);
				}
				if (employees.length >= 2){
					newGroup.setEmployee2(employees[1]);
				}
				
				if (employees.length >= 3){
					newGroup.setEmployee3(employees[2]);
				}
				
				if (employees.length >= 4){
					newGroup.setEmployee4(employees[3]);
				}
				
				if (employees.length >= 5){
					newGroup.setEmployee5(employees[4]);
				}
				
				if (employees.length >= 6){
					newGroup.setEmployee1(employees[5]);
				}
				
				groups.add(newGroup);
				
				return null;
			}
			
		};
		
		doAnswer(addGroupAnswer).when(mockDao).addGroup(any());
	}

	private void setUpExistingData() {
		// TODO Auto-generated method stub
		Group group1 = new Group();
		Group group2 = new Group();
		
		
		employee1.setEmployeeId(1);
		employee2.setEmployeeId(2);
		employee3.setEmployeeId(3);
		employee4.setEmployeeId(4);
		employee5.setEmployeeId(5);
		
		group1.setEmployee1(employee1);
		group1.setEmployee2(employee2);
		group1.setEmployee3(employee3);
		group1.setEmployee4(employee4);
		
		group2.setEmployee1(employee4);
		group2.setEmployee2(employee5);
		
		this.groups = new LinkedList<Group>(Arrays.asList(group1, group2));
	}
	
	@Test
	public void addGroupTest(){
		assertEquals(2, groupService.getAllGroups().size());
		assertEquals(1, groupService.getGroupsContainingEmployee(employee1));
		groupService.addGroup(employee1, employee2, employee3, employee4);
		assertEquals(3, groupService.getAllGroups().size());
		assertEquals(2, groupService.getGroupsContainingEmployee(employee1));
	}
	
	@Test
	public void getAllGroupsTest(){
		assertEquals(2, groupService.getAllGroups().size());
		assertNotEquals(groupService.getAllGroups().get(0), groupService.getAllGroups().get(1));
	}
	
	@Test
	public void getGroupByIdTest(){
		Group group = groupService.getGroupById(1);
		assertNotNull(group);
		assertEquals(1, group.getGroupId());
	}
	
	@Test 
	public void getNonExistingGroupByIdTest(){
		Group group = groupService.getGroupById(9001);
		assertNull(group);
	}
	
	@Test
	public void getGroupsContainingEmployeeTest(){
		//employee 4 is in two groups
		List<Group> groups = groupService.getGroupsContainingEmployee(employee4);
		assertNotNull(groups);
		assertEquals(2, groups.size());
	}
	
	@Test
	public void getSingleGroupContainingEmployeeTest(){
		//employee 1 is in two groups
		List<Group> groups = groupService.getGroupsContainingEmployee(employee1);
		assertNotNull(groups);
		assertEquals(1, groups.size());
	}
	
	@Test
	public void getGroupFromNotExistingEmployee(){
		Employee employee9001 = new Employee();
		employee9001.setEmployeeId(9001);
		List<Group> groups = groupService.getGroupsContainingEmployee(employee9001);
		assertNotNull(groups);
		assertEquals(0, groups.size());
	
	}
	
	
	
	

}
