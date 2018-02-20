package org.customannotations;

@DocumentsConsistencyCheck
public class CommonProofDocuments {
	PanCard panCard;
	Aadhar aadhar;
	BankStatement bankStmt;
	
	public PanCard getPanCard() {
		return panCard;
	}
	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
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
