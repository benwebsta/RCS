package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name="MESSAGES")
public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3772241663563172290L;

	public Message() {
		super();
	}

	@Id
	@Column(name="MESSAGE_ID")
	@SequenceGenerator(name="MESSAGE_SEQ", sequenceName="MESSAGE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_SEQ")
	@Qualifier("messageId")
	private int messageId;
	
	@ManyToOne
	@JoinColumn(name="CHAIN_ID")
	@Qualifier("chain")
	private Chain chain;
	
	@Column(name="MESSAGE")
	@Qualifier("message")
	private String message;

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", chain=" + chain + ", message=" + message + "]";
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
