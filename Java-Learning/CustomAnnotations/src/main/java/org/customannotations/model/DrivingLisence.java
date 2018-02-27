package org.customannotations.model;

import org.customannotations.annotations.ConsistencyCheck;
import org.customannotations.annotations.Key;
import org.customannotations.annotations.Validate;
import org.customannotations.enums.FieldType;

@ConsistencyCheck
public class DrivingLisence {
	@Validate(id=FieldType.STRING)
	@Key(name = "name")
	private String fullName;
	@Validate(id=FieldType.PHONE_NUMBER)
	@Key(name = "phone")
	private String phoneNumber;
	@Validate(id=FieldType.DATE_STRING)
	@Key(name = "dob")
	private String dob;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
