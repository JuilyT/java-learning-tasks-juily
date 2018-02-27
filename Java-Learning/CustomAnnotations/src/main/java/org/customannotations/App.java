package org.customannotations;

import java.util.ArrayList;

import java.util.List;

import org.customannotations.annotationhandlers.ConsistencyCheckHandler;
import org.customannotations.annotationhandlers.ValidationAnnotationHandler;
import org.customannotations.initializer.CommonProofDocumentInInitializer;
import org.customannotations.model.BackgroundCheckDoc;
import org.customannotations.model.HomeLoanVerificationDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To initiate the field level and class level annotations.
 * @author juilykumari
 *
 */
public class App 
{
	static List<ErrorMessage> errorMsgs = new ArrayList<ErrorMessage>();
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
    	ValidationAnnotationHandler fieldParser = new ValidationAnnotationHandler();
    	ConsistencyCheckHandler crossDocHandler = new ConsistencyCheckHandler();
		CommonProofDocumentInInitializer commonDocInitializer = CommonProofDocumentInInitializer.getInstance();
		BackgroundCheckDoc commonProofDocuments = commonDocInitializer.getcommonProofDocuments();
		HomeLoanVerificationDoc homeLoadVerificationDoc = commonDocInitializer.getHomeLoanVerificationDoc();
		try {
			errorMsgs.addAll(fieldParser.handle(commonProofDocuments.getPanCard()));
			errorMsgs.addAll(fieldParser.handle(commonProofDocuments.getAadhar()));
			errorMsgs.addAll(fieldParser.handle(commonProofDocuments.getBankStmt()));
			errorMsgs.addAll(crossDocHandler.handle(commonProofDocuments));
			errorMsgs.addAll(crossDocHandler.handle(homeLoadVerificationDoc));
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		for (ErrorMessage string : errorMsgs) {
			logger.debug(string.getMessage());
		}
       logger.debug("Documents are validated Successfully");
    }
}
