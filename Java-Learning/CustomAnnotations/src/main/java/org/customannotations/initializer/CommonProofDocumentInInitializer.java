package org.customannotations.initializer;

import java.util.Date;

import org.customannotations.Aadhar;
import org.customannotations.BankStatement;
import org.customannotations.CommonProofDocuments;
import org.customannotations.PanCard;

public class CommonProofDocumentInInitializer {
	private static CommonProofDocumentInInitializer INSTANCE;
	
	public CommonProofDocumentInInitializer(){
		
	}
	public static CommonProofDocumentInInitializer getInstance() {
	
		if (INSTANCE==null) {
			return new CommonProofDocumentInInitializer();
		} else {
			return INSTANCE;
		}
	}
	
	public CommonProofDocuments getcommonProofDocuments() {
		
		CommonProofDocuments documents = new CommonProofDocuments();
        documents.setAadhar(getAadhar());
        documents.setPanCard(getPanCard());
        documents.setBankStmt(getBankStmt());
        return documents;
	}

	private PanCard getPanCard() {
		 PanCard pancard = new PanCard();
		 pancard.setFatherName("Ned Stark");
		 pancard.setFullname("Arya Stark");
	     pancard.setDob(new Date(1992,1,10));
	     pancard.setPanNumber("BQCPK9794A");  
	     pancard.setIssuedBy("Ram Reddy");
	     return pancard;
	}

	private Aadhar getAadhar() {
		Aadhar aadhar = new Aadhar();
        aadhar.setId(1);
        aadhar.setAddress("address");
        aadhar.setDob(new Date(1992,1,19));
        aadhar.setFullname("Arya Stark");
        aadhar.setGender("female");
        return aadhar;
	}
	
	private BankStatement getBankStmt() {
		BankStatement bankStmt = new BankStatement();
		bankStmt.setAccountNumber("10145678910");
		bankStmt.setAddress("address");
		bankStmt.setCustomerName("Arya Stark");
		bankStmt.setMobileNumber("8007458654");
		bankStmt.setEmail("aryagmail.com");
        return bankStmt;
	}
}
