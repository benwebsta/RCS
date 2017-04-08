package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9034860264018131186L;

	@Id
	@Column(name="EMPLOYEE_ID")
	@SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName="EMPLOYEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
	@Qualifier("employeeId")
	private int employeeId;
	
	@Column(name="FIRST_NAME")
	@Qualifier("firstName")
	private String firstName;
	
	@Column(name="LAST_NAME")
	@Qualifier("lastName")
	private String lastName;
	
	@Column(name="USERNAME")
	@Qualifier("username")
	private String username;
	
	@Column(name="PASSWORD")
	@Qualifier("password")
	private int password;
	
	@Column(name="FILL")
	@Qualifier("fill")
	private boolean fill;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="APARTMENT_ID")
	private Apartment apartmentHome;
	
	
}



