package com.revature.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.beans.Apartment;
import com.revature.service.TestService;

@Ignore
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
