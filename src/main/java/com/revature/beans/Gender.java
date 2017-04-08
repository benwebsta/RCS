package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name = "GENDERS")
public class Gender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9067008932745244779L;

	@Id
	@Column(name="GENDER_ID")
	@SequenceGenerator(name="GENDER_SEQ", sequenceName="GENDER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENDER_SEQ")
	@Qualifier("genderId")
	private int genderId;
	
	@Column(name="GENDER")
	@Qualifier("gender")
	private String gender;
	
	public Gender(){
		
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Gender [genderId=" + genderId + ", gender=" + gender + "]";
	}
	
	
	
}
