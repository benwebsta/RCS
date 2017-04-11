package com.revature.web;

import static org.junit.Assert.*;
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
import com.revature.beans.Gender;
import com.revature.dao.ApartmentDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.GenderDao;
import com.revature.service.ApartmentService;
import com.revature.service.EmployeeService;
import com.revature.service.GenderService;

@Ignore("To be removed when Gender Service is ready to test")
public class GenderSeviceTest {
	
	@InjectMocks
	GenderService genderService;
	
	@Mock
	GenderDao mockDao;
	
	List<Gender> genders;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		setPreExistingData();
		mockGetGenderById();
		
	}

	private void mockGetGenderById() {
		when(mockDao.getGenderById(anyInt())).thenReturn(null);
		
		for(Gender gender : genders){
			when(mockDao.getGenderById(gender.getGenderId())).thenReturn(gender.getGender());
		}
	}

	private void setPreExistingData() {
		Gender male = new Gender();
		male.setGender("Male");
		male.setGenderId(1);
		
		Gender female = new Gender();
		female.setGender("Female");
		female.setGenderId(2);
		
		Gender coEd = new Gender();
		coEd.setGender("Co-Ed");
		coEd.setGenderId(3);
		
		Gender other = new Gender();
		other.setGender("Other");
		other.setGenderId(4);
		
		Gender tumblr = new Gender();
		tumblr.setGender("Apache Attack Helcopter");
		tumblr.setGenderId(5);
		
		genders = Arrays.asList(male, female, coEd, other, tumblr);
		
	}
	
	@Test
	public void testGetGenderById(){
		String male = genderService.getGenderById(1);
		String female = genderService.getGenderById(2);
		String other = genderService.getGenderById(4);
		String coEd = genderService.getGenderById(3);
		
		assertEquals("Male", male);
		assertEquals("Female", female);
		assertEquals("Co-Ed", coEd);
		assertEquals("Other", other);
	}
	
	@Test
	public void testgetNotExistingGenderById(){
		String none = genderService.getGenderById(42);
		assertNull(none);
	}
	
}
