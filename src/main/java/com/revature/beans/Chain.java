package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;


@Entity
@Table(name="CHAINS")
public class Chain implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4406004059407650606L;

	public Chain(){}
	
	@Id
	@Column(name="CHAIN_ID")
	@SequenceGenerator(name="CHAIN_SEQ",sequenceName="CHAIN_SEQ")
	@Qualifier("chainId")
	private int chainId;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID_1")
	@Qualifier("group1")
	private Group group1;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID_2")
	@Qualifier("group2")
	private Group group2;
	
	@OneToMany(mappedBy="chain")
	private List<Message> messagesForChain;

	public int getChainId() {
		return chainId;
	}

	public void setChainId(int chainId) {
		this.chainId = chainId;
	}

	public Group getGroup1() {
		return group1;
	}

	public void setGroup1(Group group1) {
		this.group1 = group1;
	}

	public Group getGroup2() {
		return group2;
	}

	public void setGroup2(Group group2) {
		this.group2 = group2;
	}

	@Override
	public String toString() {
		return "Chain [chainId=" + chainId + ", group1=" + group1 + ", group2=" + group2 + "]";
	}

	public List<Message> getMessagesForChain() {
		return messagesForChain;
	}

	public void setMessagesForChain(List<Message> messagesForChain) {
		this.messagesForChain = messagesForChain;
	}
}