package com.revature.web;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revature.beans.Employee;
import com.sun.mail.smtp.SMTPMessage;

@RestController
@RequestMapping("/applyToMoveRest")
public class ApplyToMoveRestController
{
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Boolean applyToMove_JSON(@RequestBody String tester, HttpSession session, ModelMap modelMap){
		
		System.out.println(tester);
		
		JsonElement jelement = new JsonParser().parse(tester);
		JsonObject jobject = jelement.getAsJsonObject();
		
		String recipientEmail = jobject.get("recipientEmail").getAsString();
		String header = jobject.get("moveHeader").getAsString();
		String body = jobject.get("moveBody").getAsString();
		
		Employee employee = (Employee) session.getAttribute("employee");
		String emailPreface = "";
	    if(recipientEmail.equals("housing@revature.com"))
	    	emailPreface = "Request To Move \n\n " + 
	    					"--------------------------------- \n\n" +
	    					"Generated by the RCS system from : \n\n" + 
	    					employee.getFirstName() + " " + employee.getLastName() + "\n" +
	    					"Email Address: " + employee.getEmail() + "\n\n" +
	    					"--------------------------------- \n\n" +
	    					"This request affects: " + employee.getFirstName() + "\n\n" + 
	    					"--------------------------------- \n\n";
	    else
	    	emailPreface = "Maintenance Request Email \n\n " + 
							"--------------------------------- \n\n" +
							"Generated by the RCS system from : \n\n" + 
							employee.getFirstName() + " " + employee.getLastName() + "\n" +
							"Email Address: " + employee.getEmail() + "\n\n" +
							"--------------------------------- \n\n" +
							"This request affects: " + employee.getFirstName() + "\n\n" + 
							"--------------------------------- \n\n";
		
		boolean result = applyToMove(employee, "bmwebster@wisc.edu", header, emailPreface + body);
		return result;
	}
	
	public boolean applyToMove(Employee employee, String recipientEmail, String subject, String body){
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	            "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "805");
	    
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication("ResidentCommunicationSystem@gmail.com", "rcspassword");
	    	}
	    });
	    try {
	    	
	    	SMTPMessage message = new SMTPMessage(session);
	        message.setFrom(new InternetAddress(employee.getEmail()));
	        message.setRecipients(Message.RecipientType.TO,
	                                 InternetAddress.parse(recipientEmail));

	        message.setSubject(subject);
	        message.setText(body);
	        message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
	        int returnOption = message.getReturnOption();
	        System.out.println(returnOption);        
	        Transport.send(message);
	        System.out.println("sent");
	        return true;
	        
	    }
	    catch(MessagingException e) {
	    	return false;
	    }
	}
}
