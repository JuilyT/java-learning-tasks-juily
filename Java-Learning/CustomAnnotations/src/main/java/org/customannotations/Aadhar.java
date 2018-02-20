package org.customannotations;

import java.util.Date;

import org.customannotations.enums.FieldType;

public class Aadhar {
	private int id;
	@Validate(id=FieldType.NAME)
	private String fullname;
	@Validate(id=FieldType.NAME)
	private String gender;
	@Validate(id=FieldType.NAME)
	private String address;
	private Date dob;
	
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
