package org.customannotations.model;

public class HomeLoanVerificationDoc {
	private DrivingLisence dl;
	private BankStatement bankStmt;
	
	public DrivingLisence getDl() {
		return dl;
	}
	public void setDl(DrivingLisence dl) {
		this.dl = dl;
	}
	public BankStatement getBankStmt() {
		return bankStmt;
	}
	public void setBankStmt(BankStatement bankStmt) {
		this.bankStmt = bankStmt;
	}
}
