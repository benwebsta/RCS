package com.revature.web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.Mockito.*;

import com.revature.beans.Apartment;
import com.revature.dao.ApartmentDao;
import com.revature.service.TestService;
import com.revature.web.TestController;

public class TestControllerTest {



	@Test
	public void test() throws Exception{
		TestController tc = new TestController();
		//assertEquals("testPage", tc.test());
	}
	
	@Test
	public void testWithMock() throws Exception{
		
		Apartment testApartment = new Apartment();
		testApartment.setAddress("123 Test Drive");
		testApartment.setCity("Washington");
		testApartment.setState("DC");
		testApartment.setApartmentId(1);
		TestService testService = mock(TestService.class);
		when(testService.getApartment()).thenReturn(testApartment.getAddress());
		TestController tc = new TestController();
		tc.testService = testService;
		
		MockMvc mockMvc = standaloneSetup(tc).build();
		mockMvc.perform(get("/")).andExpect(view().name("testPage"));
	}
}
