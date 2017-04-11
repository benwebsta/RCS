package com.revature.web;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.revature.beans.Apartment;
import com.revature.beans.Employee;
import com.revature.dao.ApartmentDao;
import com.revature.service.ApartmentService;

//@Ignore
public class ApartmentServiceTest {

	String testAddress = "123 Test st";
	Integer testZipcode = 12345;
	Integer testId = 100;
	String testState = "VA";
	String testCity = "Reston";
	
	@InjectMocks
	ApartmentService apartmentService;
	
	@Mock
	ApartmentDao mockDao;
	
	Apartment apartment1;
	Apartment apartment2;
	List<Apartment> apartments;
	Employee employee;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		createExistingData();
		mockAddNewApartment();
		mockCreateNewApartment();		
		mockGetApartmentById();
		mockGetEmployeesByApartment();
		
	}

	private void mockGetEmployeesByApartment() {
		//Mocks getting Employees By Apartment
		when(mockDao.getEmployeesByApartment(anyInt())).thenReturn(null);
		when(mockDao.getEmployeesByApartment(1)).thenReturn(apartment1.getEmployees());
		when(mockDao.getEmployeesByApartment(509)).thenReturn(apartment2.getEmployees());
	}

	private void mockGetApartmentById() {
		//Mocks getting apartment By Id
		when(mockDao.getApartmentById(anyInt())).thenReturn(null);
		when(mockDao.getApartmentById(1)).thenReturn(apartment1);
		when(mockDao.getApartmentById(509)).thenReturn(apartment2);
	}

	private void mockCreateNewApartment() {
		//Mocks getting All Apartments
		when(mockDao.getAllApartments()).thenReturn(apartments);
	}

	private void mockAddNewApartment() {
		//Mocks adding an apartment to the database 
		doAnswer(new Answer<Void>(){

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Apartment apartment = new Apartment();
				
				apartment = invocation.getArgument(0);
				apartments.add(apartment);
				return null;
				
			}}).when(mockDao).addNewApartment(any(Apartment.class));
	}

	private void createExistingData() {
		apartment1 = new Apartment();
		apartment1.setAddress("123 test drive");
		apartment1.setCity("Washington");
		apartment1.setState("DC");
		apartment1.setZipCode(12345);
		apartment1.setApartmentId(1);
		apartment1.setRoomsAvailable(2);
		apartment1.setGenderId(1);
		
		apartment2 = new Apartment();
		apartment2.setAddress("123 Obama Llama cir sw");
		apartment2.setCity("Carl");
		apartment2.setState("HATS");
		apartment2.setZipCode(02015);
		apartment2.setApartmentId(509);
		apartment2.setRoomsAvailable(1);
		apartment2.setGenderId(2);
		apartments = new ArrayList<Apartment>();
		
		apartments.add(apartment1);
		apartments.add(apartment2);
		
		//creates employee in apartment
		employee = new Employee();
		employee.setApartmentId(apartment1.getApartmentId());
		employee.setFirstName("Test");
		employee.setLastName("Case");
		List list = new ArrayList<Employee>();
		list.add(employee);
		apartment1.setEmployees(list);
		
		//creates an empty list of employees in apartment 509
		List emptyList = new ArrayList<Employee>();
		apartment2.setEmployees(emptyList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addNewApartmentTest() {
		
		assertEquals("Did not return all Apartments", 2,this.apartmentService.getAllApartments().size());
		Apartment newApartment = new Apartment();
		newApartment.setAddress(testAddress);
		newApartment.setCity(testCity);
		newApartment.setState(testState);
		newApartment.setZipCode(testZipcode);
		this.apartmentService.addNewApartment(newApartment);
		assertEquals("Did not add the new apartment", 3,this.apartmentService.getAllApartments().size());
	}
	
	@Test 
	public void getAllApartments(){
		List<Apartment> list = this.apartmentService.getAllApartments();
		//only two apartments exists, make sure only these two are returned
		assertNotNull("Apartment List returned null", list);
		assertEquals("Did not return all Apartments", 2,list.size());
		assertNotEquals("Apartments in the list must not be the same", list.get(0).getApartmentId(), list.get(1).getApartmentId());
		
	}
	
	@Test
	public void getExistingApartmentById(){
		int id = 1;
		Apartment apartment = this.apartmentService.getApartmentById(id);
		assertNotNull("Apartment returned was null", apartment);
		assertEquals("Apartment id did not match with apartment id requested", id, apartment.getApartmentId());
	}
	
	@Test
	public void getNonExistingApartmentById(){
		int id = 2;
		Apartment apartment = this.apartmentService.getApartmentById(id);
		assertNull("Apartment returned was not null", apartment);
	}
	
	@Test
	public void getEmployeesInApartmentTest(){
		int id = 1;
		List<Employee> employees = this.apartmentService.getEmployeesByApartment(id);
		assertNotNull("Employee List in Apartment was null", employees);
		assertEquals("Employee List return from apartment was not 1", 1, employees.size());
	}
	
	@Test
	public void getNoEmployeesInApartmentTest(){
		int id = 509;
		List<Employee> employees = this.apartmentService.getEmployeesByApartment(id);
		assertNotNull("Employee List in Apartment was null", employees);
		assertEquals("Employee List return from apartment was not 0", 0, employees.size());
	}
	
	@Test
	public void getEmployeesInNonExistingApartmentTest(){
		int id = 2;
		List<Employee> employees = this.apartmentService.getEmployeesByApartment(id);
		assertNull("Employee List in non-existing apartment was not null", employees);
	}
	
	

}
