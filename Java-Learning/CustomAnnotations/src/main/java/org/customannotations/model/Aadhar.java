package org.customannotations.model;

import java.util.Date;

import org.customannotations.annotations.ConsistencyCheck;
import org.customannotations.annotations.Key;
import org.customannotations.annotations.Validate;
import org.customannotations.enums.FieldType;

@ConsistencyCheck
public class Aadhar {
	private int id;
	@Validate(id=FieldType.STRING)
	@Key(name = "name")
	private String fullname;
	@Validate(id=FieldType.STRING)
	private String gender;
	@Validate(id=FieldType.STRING)
	private String address;
	@Key(name="dob")
	private String dob;
	
	public Aadhar() {
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
