package com.revature.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.revature.beans.Chain;
import com.revature.beans.Employee;
import com.revature.beans.Group;
import com.revature.beans.Message;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.service.ApartmentService;
import com.revature.service.ChainService;
import com.revature.service.EmployeeService;
import com.revature.service.GroupService;
import com.revature.service.HRService;
import com.revature.service.MessageService;

@RestController
@RequestMapping(path="/messageRest")
public class MessageRestController {
	
	@Autowired
	ChainService chainService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ApartmentService apartmentService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	HRService hrService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody  String listMessageChains( 
		
			ModelMap modelMap, HttpSession session){
			//session.setAttribute("employee", new EmployeeDaoImpl().getEmployeeById(3));
			Employee employee = (Employee) session.getAttribute("employee");
			String jsonResponse = "";
			if(employee == null){
				//employee is not logged in
				//response.sendError(403);
				return "";
			} 
			
			List<Group> groups = groupService.getGroupsContainingEmployee(employee);
			List<Chain> chains = new LinkedList<Chain>();
			for (Group g : groups){
				chains.addAll(chainService.getChainsByGroupOne(g));
				chains.addAll(chainService.getChainsByGroupTwo(g));
			}
			
			//sorts in order, because streams works best in it
			Collections.sort(chains, new Comparator<Chain>() {
				@Override
				public int compare(Chain o1, Chain o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.getChainId(), o2.getChainId());
				}
			});
			
			//removes repeated entries
			for(int i = 0; i < chains.size(); i++){
				while(i+1 < chains.size() && chains.get(i).getChainId() == chains.get(i+1).getChainId()){
					chains.remove(i);
				}
			}
			
			System.out.println(chains.size());
			
			Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {

				@Override
				public boolean shouldSkipClass(Class<?> arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean shouldSkipField(FieldAttributes arg0) {
					// TODO Auto-generated method stub
					return arg0.getName().equals("password");
				}
				

				

			}).create();
			
			jsonResponse = gson.toJson(chains);
			System.out.println(jsonResponse);
			return jsonResponse;
	}
	
	@RequestMapping(path="/{chainId}", method=RequestMethod.GET)
	public @ResponseBody String getMessagesForChain(@PathVariable String chainId, ModelMap modelMap, HttpSession session){
		String response = "";
		Chain chain = null;
		List<Message> messages = new LinkedList<>();
		try{
			chain = chainService.getChainById(Integer.parseInt(chainId));
			messages = messageService.getMessagesByChain(chain);
		} catch (NumberFormatException e){
			chain = null;
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {

			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean shouldSkipField(FieldAttributes arg0) {
				// TODO Auto-generated method stub
				return arg0.getName().equals("password");
			}
			

			

		}).create();
		response = gson.toJson(messages);
		return response;
	}
	
	@RequestMapping(path="/newChain", method=RequestMethod.POST)
	public @ResponseBody Boolean addNewMessageChain(@RequestBody String json, ModelMap modelMap, HttpSession session){
		/*
		JsonObject o = new JsonObject();
		o.addProperty("isFromApartment", false);
		o.addProperty("isToApartment", true);
		o.addProperty("message", "Hello World");
		o.addProperty("otherEmployee", "bella");
		json = o.toString();
		
		session.setAttribute("employee", employeeService.getEmployeeById(3));
		*/
		JsonElement reader = new JsonParser().parse(json);
		JsonObject jObject = reader.getAsJsonObject();
		Employee employee = (Employee) session.getAttribute("employee");
		boolean result = false;
		//gets properties from json
		
		try{
			boolean usingFromApartmentGroup = jObject.get("isFromApartment").getAsBoolean();
			boolean usingToApartmentGroup = jObject.get("isToApartment").getAsBoolean();
			String usernameReference = jObject.get("otherEmployee").getAsJsonObject().get("username").getAsString();
			Employee otherEmployee = employeeService.getEmployeeByUsername(usernameReference);
			String messageText = jObject.get("message").getAsString();
			
			Group fromGroup = generateGroupFromEmployee(employee, usingFromApartmentGroup);
			Group toGroup = generateGroupFromEmployee(otherEmployee, usingToApartmentGroup);
			groupService.addGroup(fromGroup);
			groupService.addGroup(toGroup);
			
			Chain chain = new Chain();
			chain.setGroup1(fromGroup);
			chain.setGroup2(toGroup);
			Integer chainId = chainService.addNewChain(chain);
			Message message = new Message();
			message.setChainId(chainId);
			message.setMessage(messageText);
			messageService.AddMessage(message);
			result = message.getMessageId() > 0;
		} catch (Exception e){
			result = false;
		}
		
		
		return result;
	}
	
	@RequestMapping(path="/UpdateMessageChain", method=RequestMethod.POST)
	public boolean addMessage(@RequestBody String json, ModelMap modelMap, HttpSession session){
		//session.setAttribute("employee", employeeService.getEmployeeById(3));
		Employee employee = (Employee) session.getAttribute("employee");		
		Boolean okToAdd = false;
		boolean result = false;
		
		JsonObject jObject = new JsonParser().parse(json).getAsJsonObject();
		int chainId = jObject.get("messagechain").getAsInt();
		String messageBody = jObject.get("message").getAsString();
		Chain chain = chainService.getChainById(chainId);
		
		//checks if employee is in a group of the chain
		if(employee != null && chain != null){
			List<Group> groupsToCheck = groupService.getGroupsContainingEmployee(employee);
			for (Group g : groupsToCheck){
				if (g.getGroupId() == chain.getGroup1().getGroupId() || g.getGroupId() == chain.getGroup2().getGroupId()){
					okToAdd = true;
					break;
				}
			}
		}
		
		//adds message to message chain
		if (okToAdd){
			Message message = new Message();
			message.setChainId(chain.getChainId());
			message.setMessage(messageBody);
			messageService.AddMessage(message);
			result = message.getMessageId() > 0;
		}
		
		return result;
	}
	
	@RequestMapping(path="/getMessagebleUsers", method=RequestMethod.GET)
	public String getUsers(ModelMap modelMap, HttpSession session){
		List<Employee> employees = hrService.getAllEmployeesInHousing();
		JsonObject json = new JsonObject();
		JsonArray employeesArray = new JsonArray();
		for (Employee employee: employees){
			JsonObject eObject = new JsonObject();
			eObject.addProperty("firstName", employee.getFirstName());
			eObject.addProperty("lastName", employee.getLastName());
			eObject.addProperty("username", employee.getUsername());
			employeesArray.add(eObject);
		}
		json.add("employees", employeesArray);
		return json.toString();
	}

	private Group generateGroupFromEmployee(Employee employee, boolean usingFromApartmentGroup) {
		//gets the From Group
		List<Employee> employees = new LinkedList<Employee>();
		if (usingFromApartmentGroup){
			employees = apartmentService.getEmployeesByApartment(employee.getApartmentId());
		} else {
			employees.add(employee);	
		}
		//fill out any empty records
		for (int i = employees.size() ; i < 6; i++){
			employees.add(null);
		}
		Group group = new Group();
		group.setEmployee1(employees.get(0));
		group.setEmployee2(employees.get(1));
		group.setEmployee3(employees.get(2));
		group.setEmployee4(employees.get(3));
		group.setEmployee5(employees.get(4));
		group.setEmployee6(employees.get(5));
		return group;
		
	}

}
