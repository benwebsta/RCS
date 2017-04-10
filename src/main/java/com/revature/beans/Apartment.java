package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Entity
//Table name in DB
@Table(name = "APARTMENTS")
public class Apartment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6391088910725394108L;
	
	@Id
	//Column name in DB
	@Column(name="APARTMENT_ID")
	//Sequence name in DB and sequence name we call it
	@SequenceGenerator(name="APARTMENT_SEQ", sequenceName="APARTMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APARTMENT_SEQ")
	//the name every other bean sees this variable as
	@Qualifier("apartmentId")
	private int apartmentId;
	
	//Column name in DB
	@Column(name="ADDRESS")
	//the name every other bean sees this variable as
	@Qualifier("address")
	private String address;
	
	//Column name in DB
	@Column(name="CITY")
	//the name every other bean sees this variable as
	@Qualifier("city")
	private String city;
	
	//Column name in DB
	@Column(name="STATE")
	//the name every other bean sees this variable as
	@Qualifier("state")
	private String state;
	
	//Column name in DB
	@Column(name="ZIP_CODE")
	@Qualifier("zipCode")
	//the name every other bean sees this variable as
	private int zipCode;
	
	//Column name in DB
	@Column(name="GENDER_ID")
	//the name every other bean sees this variable as
	@Qualifier("genderId")
	private int genderId;

	//Column name in DB
	@Column(name="ROOMS_AVAILABLE")
	//the name every other bean sees this variable as
	@Qualifier("roomsAvailable")
	private int roomsAvailable;

	//mapping to variable in employee bean(every apartment has a list of tenants)
	@OneToMany(mappedBy = "apartmentId", fetch=FetchType.EAGER)
	private List<Employee> employees;
	
	public Apartment(){
		
	};
	
	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getRoomsAvailable() {
		return roomsAvailable;
	}

	public void setRoomsAvailable(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", genderId=" + genderId + ", roomsAvailable=" + roomsAvailable
				+ ", employees=" + employees + "]";
	}

	
	
	
}


