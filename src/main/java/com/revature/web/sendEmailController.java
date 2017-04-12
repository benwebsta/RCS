//File Name SendEmail.java
package com.revature.web;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import com.revature.beans.Employee;
import com.sun.mail.smtp.SMTPMessage;

public class sendEmailController {

	public void sendEmail(Employee employee, String recipientEmail, String subject, String body){    
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	            "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "805");

	    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("ResidentCommunicationSystem@gmail.com","rcspassword");
	        }
	    });

	    try {

	        SMTPMessage message = new SMTPMessage(session);
	        message.setFrom(new InternetAddress("employee . getEmail()"));
	        message.setRecipients(Message.RecipientType.TO,
	                                 InternetAddress.parse(recipientEmail));

	        message.setSubject(subject);
	        message.setText(body);
	        message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
	        int returnOption = message.getReturnOption();
	        System.out.println(returnOption);        
	        Transport.send(message);
	        System.out.println("sent");

	    }
	     catch (MessagingException e) {
	        throw new RuntimeException(e);         
	     }
	}
}