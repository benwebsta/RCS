package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Qualifier;

public class TransferRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5202410620522136544L;

	@Id
	@Column(name="TRANS_REQ_ID")
	@SequenceGenerator(name="TRANS_REQ_SEQ", sequenceName="TRANS_REQ_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANS_REQ_SEQ")
	@Qualifier("transferRequestId")
	private int transferRequestId;
	
	@Column(name="MESSAGE_ID")
	@Qualifier("messageId")
	private int messageId;
	
	@Column(name="SENDER_ID")
	@Qualifier("senderId")
	private int senderId;
	
	@Column(name="TARGET_APT_ID")
	@Qualifier("targetApartmentId")
	private int targetApartmentId;
	
	public TransferRequest(){
		
	}
	
	public int getTransferRequestId() {
		return transferRequestId;
	}

	public void setTransferRequestId(int transferRequestId) {
		this.transferRequestId = transferRequestId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getTargetApartmentId() {
		return targetApartmentId;
	}

	public void setTargetApartmentId(int targetApartmentId) {
		this.targetApartmentId = targetApartmentId;
	}

	@Override
	public String toString() {
		return "TransferRequests [transferRequestId=" + transferRequestId + ", messageId=" + messageId + ", senderId="
				+ senderId + ", targetApartmentId=" + targetApartmentId + "]";
	} 
	
	
	
}
