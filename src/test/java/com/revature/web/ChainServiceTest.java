package com.revature.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.revature.beans.Chain;
import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.dao.ChainDao;
import com.revature.service.ChainService;

@Ignore
public class ChainServiceTest {

	@InjectMocks
	ChainService chainService;
	
	@Mock
	ChainDao mockDao;
	
	Chain chain;
	List<Group> groups;
	Group group1;
	Group group2;
	Employee employee1;
	Employee employee2;
	Employee employee3;
	Employee employee4;
	Employee employee5;

	private List<Chain> chains;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		setPreExistingData();
		mockAddNewChainMethod();
		mockGetAllChains();
		mockGetChainById();
		mockGetChainByGroupOne(chains);
		mockGetChainByGroupTwo(chains);
	}

	private void mockGetChainByGroupTwo(List<Chain> chains) {
		doAnswer(new Answer<List<Chain>>(){

			@Override
			public List<Chain> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Group groupTwo = invocation.getArgument(0);
				List<Chain> resultChain = new LinkedList<Chain>();
				chains.forEach(c -> {
					if (c.getGroup2().getGroupId() == groupTwo.getGroupId()) 
						resultChain.add(c);
						}
				);
				
				return resultChain;
			}
		}).when(mockDao).getChainsByGroupTwo(ArgumentMatchers.any(Group.class));
	}

	private void mockGetChainByGroupOne(List<Chain> chains1) {
		doAnswer(new Answer<List<Chain>>(){

			@Override
			public List<Chain> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Group groupOne = invocation.getArgument(0);
				List<Chain> resultChain = new LinkedList<Chain>();
				chains.forEach(c -> {
					if (c.getGroup1().getGroupId() == groupOne.getGroupId()) 
						resultChain.add(c);
						}
				);
				
				return resultChain;
			}
		}).when(mockDao).getChainsByGroupOne(ArgumentMatchers.any(Group.class));
		
	}

	private void mockGetChainById() {
		when(mockDao.getChainById(ArgumentMatchers.anyInt())).thenReturn(null);
		when(mockDao.getChainById(1)).thenReturn(chain);
	}

	private void mockGetAllChains() {
		when(mockDao.getAllChains()).thenReturn(chains);
	}
	
	

	private void mockAddNewChainMethod() {
		doAnswer(new Answer<Void>(){

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Chain newChain = invocation.getArgument(0);
				chains.add(newChain);
				return null;
			}
			
			
		}).when(mockDao).addNewChain(ArgumentMatchers.any(Chain.class));
		
	}

	private void setPreExistingData() {
		group1 = new Group();
		group2 = new Group();
		employee1 = new Employee();
		employee2 = new Employee();
		employee3 = new Employee();
		employee4 = new Employee();
		employee5 = new Employee();
		
		employee1.setEmployeeId(1);
		employee2.setEmployeeId(2);
		employee3.setEmployeeId(3);
		employee4.setEmployeeId(4);
		employee5.setEmployeeId(5);
		
		group1.setEmployee1(employee1);
		group1.setEmployee2(employee2);
		group1.setEmployee3(employee3);
		group2.setEmployee1(employee4);
		group2.setEmployee2(employee5);
		
		chains = new LinkedList<Chain>();
		
		chain = new Chain();
		chain.setGroup1(group1);
		chain.setGroup2(group2);
		chain.setChainId(1);
		
		chains.add(chain);	
	}
	
	@Test
	public void addNewChainTest(){
		Group groupThree = new Group();
		groupThree.setEmployee1(employee1);
		Group groupFour = new Group();
		groupFour.setEmployee1(employee5);
		Chain newChain = new Chain();
		newChain.setGroup1(groupThree);
		newChain.setGroup2(groupFour);
		
		assertEquals(1, this.chainService.getAllChains().size());
		this.chainService.addNewChain(newChain);
		assertEquals(2, this.chainService.getAllChains().size());
		List<Chain> chains = this.chainService.getAllChains();
		assertFalse(chains.get(0).getChainId() == chains.get(1).getChainId());
	}
	
	@Test
	public void getAllChainsTest(){
		List<Chain> chains = this.chainService.getAllChains();
		assertNotNull(chains);
		assertEquals(1, chains.size());
	}
	
	@Test
	public void getChainById(){
		Chain chain = this.chainService.getChainById(1);
		assertNotNull(chain);
		assertEquals(1, chain.getChainId());
	}
	
	@Test
	public void getNotExistingChainById(){
		Chain chain = this.chainService.getChainById(9001);
		assertNull(chain);
	}
	
	@Test
	public void getChainsByGroupOne(){
		List<Chain> chains = this.chainService.getChainsByGroupOne(group1);
		assertNotNull(chains);
		assertEquals(1, chains.size());
	}
	
	@Test
	public void getEmptyChainsByGroupOne(){
		List<Chain> chains = this.chainService.getChainsByGroupOne(group2);
		assertNotNull(chains);
		assertEquals(0, chains.size());		
	}
	
	@Test
	public void getChainsByGroupTwo(){
		List<Chain> chains = this.chainService.getChainsByGroupTwo(group2);
		assertNotNull(chains);
		assertEquals(1, chains.size());
	}
	
	@Test
	public void getEmptyChainsByGroupTwo(){
		List<Chain> chains = this.chainService.getChainsByGroupTwo(group1);
		assertNotNull(chains);
		assertEquals(0, chains.size());		
	}
	
	
	
	
	
	
	
	
	
}
