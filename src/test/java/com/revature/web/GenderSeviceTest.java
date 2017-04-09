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
	
	
}
