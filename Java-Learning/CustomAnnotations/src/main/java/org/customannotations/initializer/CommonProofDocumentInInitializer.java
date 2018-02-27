package org.customannotations.initializer;

import java.util.Date;

import org.customannotations.model.Aadhar;
import org.customannotations.model.BankStatement;
import org.customannotations.model.DrivingLisence;
import org.customannotations.model.HomeLoanVerificationDoc;
import org.customannotations.model.BackgroundCheckDoc;
import org.customannotations.model.PanCard;

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
	
	public BackgroundCheckDoc getcommonProofDocuments() {
		
		BackgroundCheckDoc documents = new BackgroundCheckDoc();
        documents.setAadhar(getAadhar());
        documents.setPanCard(getPanCard());
        documents.setBankStmt(getBankStmt());
        return documents;
	}

	private PanCard getPanCard() {
		 PanCard pancard = new PanCard();
		 pancard.setFatherName("Ned Stark");
		 pancard.setFullname("Arya Stark");
	     pancard.setDob("1992-1-10");
	     pancard.setPanNumber("BQCPK9794A");  
	     pancard.setIssuedBy("Ram Reddy");
	     return pancard;
	}

	private Aadhar getAadhar() {
		Aadhar aadhar = new Aadhar();
        aadhar.setId(1);
        aadhar.setAddress("address");
        aadhar.setDob("1992-1-10");
        aadhar.setFullname("Arya Stark");
        aadhar.setGender("female");
        return aadhar;
	}
	
	public HomeLoanVerificationDoc getHomeLoanVerificationDoc() {		
		HomeLoanVerificationDoc documents = new HomeLoanVerificationDoc();
        documents.setBankStmt(getBankStmt());
        documents.setDl(getDrivingLisence());
        return documents;
	}
	
	private BankStatement getBankStmt() {
		 BankStatement bankstmt = new BankStatement();
		 bankstmt.setAccountNumber("abcd123456");
		 bankstmt.setAddress("address");
		 bankstmt.setCustomerName("Arya");
		 bankstmt.setEmail("arya.gmail.com");
		 bankstmt.setMobileNumber("1234567891");
	     return bankstmt;
	}

	private DrivingLisence getDrivingLisence() {
		DrivingLisence dl = new DrivingLisence();
	   dl.setDob("1992-1-10");
	   dl.setFullName("Arya Stark");
	   dl.setPhoneNumber("9745678989");
	   return dl;
	}
}
