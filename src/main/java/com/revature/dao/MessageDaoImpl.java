package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Chain;
import com.revature.beans.Message;
import com.revature.config.HibernateUtil;

public class MessageDaoImpl implements MessageDao {

	@Override
	public List<Message> getAllMessages() {
		Session sess = HibernateUtil.getSession();
		List<Message> messageList;
		messageList = sess.createCriteria(Message.class).list();
		sess.close();
		return messageList;
	}

	@Override
	public Message getMessageById(int id) {
		Session sess = HibernateUtil.getSession();
		Integer messageId = id;
		Message message = (Message) sess.get(Message.class, messageId);
		sess.close();
		return message;
		
	}

	@Override
	public List<Message> getMessagesByChain(Chain chain) {
		Session sess = HibernateUtil.getSession();
		List<Message> messages = null;
		Criteria c = sess.createCriteria(Message.class);
		if (chain != null){
			c.add(Restrictions.eq("chainId", chain.getChainId()));
			c.addOrder(Order.desc("messageId"));
			messages = c.list();
		}
		sess.close();
		return messages;
	}

	@Override
	public void AddMessage(Message message) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		try
		{
			tx = sess.beginTransaction();
			sess.saveOrUpdate(message);
			tx.commit();
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			sess.close();
		}
		
	
		
		
	}

}
