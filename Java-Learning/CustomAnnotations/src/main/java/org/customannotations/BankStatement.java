package org.customannotations;

import java.util.List;

import org.customannotations.enums.FieldType;

public class BankStatement {
	@Validate(id=FieldType.ACCOUNT)
	private String accountNumber;
	@Validate(id=FieldType.NAME)
	private String customerName;	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private List<Transaction> transactions;
	@Validate(id=FieldType.NAME)
	private String address;
	@Validate(id=FieldType.PHONE_NUMBER)
	private String mobileNumber;
	@Validate(id=FieldType.EMAIL)
	private String email;
}
