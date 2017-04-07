package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Apartments")
public class Apartment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5471182534071429189L;

	@Id
	@Column(name="apartment_id")
	public int id;
	
	
	@Column(name="address")
	public String address;
	
	@Column(name="city")
	public String city;
	
	@Column(name="state")
	public String state;
	
	@Column(name="zip_code")
	public String zipCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Apartment() {
		super();
	}

	public Apartment(int id, String address, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + "]";
	}
	
	
}
