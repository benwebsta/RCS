package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="GROUPS")
public class Group implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5321827569976101743L;

	public Group() {
		super();
	}

	@Id
	@Column(name="GROUP_ID")
	@SequenceGenerator(name="GROUP_SEQ", sequenceName="GROUP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUP_SEQ")
	@Qualifier("groupId")
	private int groupId;
	
	//Many to one is used because there is nothing stopping an employee being in more the on group
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID_1")
	@Qualifier("employee1")
	private Employee employee1;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID_2")
	@Qualifier("employee2")
	private Employee employee2;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID_3")
	@Qualifier("employee3")
	private Employee employee3;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID_4")
	@Qualifier("employee4")
	private Employee employee4;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID_5")
	@Qualifier("employee5")
	private Employee employee5;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID_6")
	@Qualifier("employee6")
	private Employee employee6;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public Employee getEmployee1() {
		return employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

	public Employee getEmployee3() {
		return employee3;
	}

	public void setEmployee3(Employee employee3) {
		this.employee3 = employee3;
	}

	public Employee getEmployee4() {
		return employee4;
	}

	public void setEmployee4(Employee employee4) {
		this.employee4 = employee4;
	}

	public Employee getEmployee5() {
		return employee5;
	}

	public void setEmployee5(Employee employee5) {
		this.employee5 = employee5;
	}

	public Employee getEmployee6() {
		return employee6;
	}

	public void setEmployee6(Employee employee6) {
		this.employee6 = employee6;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", employee1=" + employee1 + ", employee2=" + employee2 + ", employee3="
				+ employee3 + ", employee4=" + employee4 + ", employee5=" + employee5 + ", employee6=" + employee6
				+ "]";
	}
	
	
}
