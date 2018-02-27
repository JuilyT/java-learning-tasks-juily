package org.customannotations.model;

public class BackgroundCheckDoc {
	PanCard panCard;
	Aadhar aadhar;
	BankStatement bankStmt;
	
	public PanCard getPanCard() {
		return panCard;
	}
	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}
	public BackgroundCheckDoc() {
		super();
	}
	public BackgroundCheckDoc(PanCard panCard, Aadhar aadhar, BankStatement bankStmt) {
		super();
		this.panCard = panCard;
		this.aadhar = aadhar;
		this.bankStmt = bankStmt;
	}
	public Aadhar getAadhar() {
		return aadhar;
	}
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	public BankStatement getBankStmt() {
		return bankStmt;
	}
	public void setBankStmt(BankStatement bankStmt) {
		this.bankStmt = bankStmt;
	}
}
