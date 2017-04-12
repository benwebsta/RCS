package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Chain;
import com.revature.beans.Message;
import com.revature.dao.MessageDao;
import com.revature.dao.MessageDaoImpl;

@Component
public class MessageService {
	
	MessageDao messageDao = new MessageDaoImpl();
	
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return messageDao.getAllMessages();
	}

	
	public Message getMessageById(int id) {
		// TODO Auto-generated method stub
		return messageDao.getMessageById(id);
	}

	
	public List<Message> getMessagesByChain(Chain chain) {
		// TODO Auto-generated method stub
		return messageDao.getMessagesByChain(chain);
	}

	
	public void AddMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.AddMessage(message);
	}

	
}
