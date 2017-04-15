package com.revature.web;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
import com.revature.dao.ApartmentDao;
import com.revature.dao.EmployeeDao;
import com.revature.service.ApartmentService;
import com.revature.service.EmployeeService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//@Ignore("To be used when EmployeeService is ready to be tested")
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeDao mockDao;
	
	Employee employee1;
	Employee employee2;
	Employee employee3;
	List<Employee> employees;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	
		setupPrexistingData();
		mockGetEmployeeById();
		mockLoginEmployee();
		mockUpdateEmployee();
	}

	private void mockUpdateEmployee() {
		Answer<Boolean> employeeAnswer = new Answer<Boolean>(){

			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				boolean b = false;
				Employee employeeToUpdate = invocation.getArgument(0);
				for(int i = 0; i < employees.size(); i++){
					Employee employeeToCheck = employees.get(i);
					if(employeeToUpdate.getEmployeeId() == employeeToCheck.getEmployeeId()){
						employees.set(i, employeeToUpdate);
						b = true;
						break;
					}					
				}
				
				return b;
			}
			
		};
		
		when(mockDao.updateEmployee(ArgumentMatchers.any(Employee.class))).thenAnswer(employeeAnswer);
		
	}

	private void mockLoginEmployee() {
		when(mockDao.getEmployeeByLogin(anyString(), anyString())).thenReturn(null);
		when(mockDao.getEmployeeByLogin("username1", "password")).thenReturn(employee1);
		when(mockDao.getEmployeeByLogin("username2", "Bobbert")).thenReturn(employee2);
		when(mockDao.getEmployeeByLogin("username3", "test1234")).thenReturn(employee3);
	}

	private void mockGetEmployeeById() {
		Answer<Employee> getEmployeeAnswer = new Answer<Employee>(){

			@Override
			public Employee answer(InvocationOnMock invocation) throws Throwable {
				Integer id = invocation.getArgument(0);
				Employee employeeToReturn = null;
				for(Employee e: employees){
					if(e.getEmployeeId() == id){
						employeeToReturn = e;
					}
				}
				return employeeToReturn;
				}
			};
			when(mockDao.getEmployeeById(ArgumentMatchers.anyInt())).thenAnswer(getEmployeeAnswer);
			
		
	}

	private void setupPrexistingData() {
		// TODO Auto-generated method stub
		employees  = new LinkedList<Employee>();
		employee1 = new Employee();
		employee1.setEmployeeId(1);
		employee1.setUsername("username1");
		employee1.setPassword("password");
		
		employee2 = new Employee();
		employee2.setEmployeeId(2);
		employee2.setUsername("username2");
		employee2.setPassword("Bobbert");
		
		employee3 = new Employee();
		employee3.setEmployeeId(3);
		employee3.setUsername("username3");
		employee3.setPassword("test1234");
		
		employees.addAll(Arrays.asList(employee1, employee2, employee3));
		
		
	}


	@Test
	public void getEmployeeByIdTest(){
		Employee employee = employeeService.getEmployeeById(1);
		Employee employee2 = employeeService.getEmployeeById(2);
		
		assertNotNull("Employee with id 1 was null", employee);
		assertNotNull("EMployee with id 2 was null", employee2);
		
		assertNotEquals("Two employees returned are not suppse to be equal", employee1, employee2);
		assertTrue("Employee ids are not suppse to be equal", employee1.getEmployeeId() != employee2.getEmployeeId());
	}
	
	@Test
	public void getNotExistingEmployeeByIdTest(){
		Employee employee = employeeService.getEmployeeById(9001);
		assertNull("Employee returned with null", employee);
	}
	
	@Test
	public void loginEmployeeTest(){
		Employee employee = employeeService.loginEmployee("username1", "password");
		assertNotNull("Employee was null", employee);
		assertEquals("username is not correct", "username1", employee.getUsername());
		assertEquals("password is not correct", "password", employee.getPassword());
	}
	
	@Test 
	public void loginEmployeeWithWrongPasswordTest(){
		Employee employee = employeeService.loginEmployee("username", "Bobbert");
		assertNull("Employee was not null", employee);
	}
	
	@Test
	public void loginEmployeeWithWrongUsernameAndPasswordTest(){
		Employee employee = employeeService.loginEmployee("wrong", "Its over 9001");
		assertNull("Employee was not null", employee);
	}
	
	@Test
	public void loginEmployeeWithEmptyDataTest(){
		Employee employee = employeeService.loginEmployee("", "");
		assertNull("Employee was not null", employee);
	}
	
	@Test
	public void updateEmployeeTest(){
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("newName");
		assertNotEquals(employeeService.getEmployeeById(1).getFirstName(), employee.getFirstName());
		assertEquals(true, employeeService.updateEmployee(employee));
		assertEquals(employee.getFirstName(), mockDao.getEmployeeById(1).getFirstName());
	}
	
	@Test
	public void updateNotExistingEmployeeTest(){
		Employee employee = new Employee();
		employee.setEmployeeId(9001);
		employee.setFirstName("newName");
		assertEquals(false, employeeService.updateEmployee(employee));
		Employee nullEmployee = employeeService.getEmployeeById(9001);
		assertNull("Employee should not have been added here, update existing only", nullEmployee);
	}

}
