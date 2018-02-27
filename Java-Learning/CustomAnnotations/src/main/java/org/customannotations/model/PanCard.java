package org.customannotations.model;

import org.customannotations.annotations.ConsistencyCheck;
import org.customannotations.annotations.Key;
import org.customannotations.annotations.Validate;
import org.customannotations.enums.FieldType;

@ConsistencyCheck
public class PanCard {
	@Validate(id=FieldType.STRING)
	@Key(name = "name")
	private String fullname;
	@Validate(id=FieldType.STRING)
	private String fatherName;
	@Validate(id=FieldType.PAN_NUMBER)
	private String panNumber;
	@Validate(id=FieldType.STRING)
	private String issuedBy;
	@Key(name = "dob")
	private String dob;
	
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/*public static void main(String[] args) throws Exception {
		DocumentConsistencyCheckHandler parser = new DocumentConsistencyCheckHandler();
		CommonProofDocumentInInitializer commonDocInitializer = CommonProofDocumentInInitializer.getInstance();
		CommonProofDocuments commonProofDocuments = commonDocInitializer.getcommonProofDocuments();
		parser.handle(commonProofDocuments);
    }*/
}
