package org.customannotations;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class DocumentConsistencyCheckHandler{
	
	public List<ErrorMessage> handle(CommonProofDocuments docs) throws Exception {
		Class<CommonProofDocuments> obj = CommonProofDocuments.class;
		List<ErrorMessage> errors = null;
		if (obj.isAnnotationPresent(DocumentsConsistencyCheck.class)) {
			errors = new ArrayList<ErrorMessage>();
			Annotation annotation = obj.getAnnotation(DocumentsConsistencyCheck.class);
			DocumentsConsistencyCheck ann = (DocumentsConsistencyCheck) annotation;
			Aadhar aadharcard = docs.getAadhar();
			PanCard panCard = docs.getPanCard();
			ErrorMessage msg = null;
			if(!aadharcard.getFullname().equals(panCard.getFullname())) {
				msg = new ErrorMessage(aadharcard.getFullname()+" is not matching "+panCard.getFullname(), aadharcard);
			}
			else if(!aadharcard.getDob().equals(panCard.getDob())) {
				msg = new ErrorMessage(aadharcard.getDob()+" is not matching "+panCard.getDob(), aadharcard);
			}
			errors.add(msg);
		}
		return errors;
	}
}
