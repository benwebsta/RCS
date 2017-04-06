package com.revature.web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class TestControllerTest {



	@Test
	public void test() throws Exception{
		TestController tc = new TestController();
		assertEquals("testPage", tc.test());
	}
	
	@Test
	public void testWithMock() throws Exception{
		TestController tc = new TestController();
		MockMvc mockMvc = standaloneSetup(tc).build();
		mockMvc.perform(get("/")).andExpect(view().name("testPage"));
	}

}
