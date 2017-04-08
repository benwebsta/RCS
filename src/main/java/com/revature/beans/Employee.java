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
	
	@Column(name= "password")
	@Qualifier("password")
	private int password;
	
	@Column(name = "APARTMENT_ID")
	@Qualifier("apartmentId")
	private int apartmentId;
	
	@Column(name = "GENDER_ID")
	@Qualifier("genderId")
	private int genderId;
	
	@Column(name = "FILL")
	@Qualifier("fill")
	private int fill;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="APARTMENT_ID")
	private Apartment apartmentHome;
	
	public Employee(){
		
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getFill() {
		return fill;
	}

	public void setFill(int fill) {
		this.fill = fill;
	}

	public Apartment getApartmentHome() {
		return apartmentHome;
	}

	public void setApartmentHome(Apartment apartmentHome) {
		this.apartmentHome = apartmentHome;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", apartmentId=" + apartmentId + ", genderId="
				+ genderId + ", fill=" + fill + ", apartmentHome=" + apartmentHome + "]";
	}
	
}



