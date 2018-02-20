package org.customannotations;

import java.util.Date;

import org.customannotations.enums.FieldType;
import org.customannotations.initializer.CommonProofDocumentInInitializer;

public class PanCard {
	@Validate(id=FieldType.NAME)
	private String fullname;
	@Validate(id=FieldType.NAME)
	private String fatherName;
	@Validate(id=FieldType.PAN_NUMBER)
	private String panNumber;
	@Validate(id=FieldType.NAME)
	private String issuedBy;
	private Date dob;
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/*public static void main(String[] args) throws Exception {
		DocumentConsistencyCheckHandler parser = new DocumentConsistencyCheckHandler();
		CommonProofDocumentInInitializer commonDocInitializer = CommonProofDocumentInInitializer.getInstance();
		CommonProofDocuments commonProofDocuments = commonDocInitializer.getcommonProofDocuments();
		parser.handle(commonProofDocuments);
    }*/
}
