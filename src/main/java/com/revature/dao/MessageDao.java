package com.revature.dao;

import java.io.Serializable;
import java.util.List;

import com.revature.beans.Chain;
import com.revature.beans.Message;

public interface MessageDao  {
	
	void AddMessage(Message message);
	List<Message> getAllMessages();
	Message getMessageById(int id);
	List<Message> getMessagesByChain(Chain chain);
}
