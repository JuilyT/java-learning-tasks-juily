package org.customannotations;

import java.util.ArrayList;
import java.util.List;

import org.customannotations.initializer.CommonProofDocumentInInitializer;
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
    	DocumentConsistencyCheckHandler crossDocumentParser = new DocumentConsistencyCheckHandler();
		CommonProofDocumentInInitializer commonDocInitializer = CommonProofDocumentInInitializer.getInstance();
		CommonProofDocuments commonProofDocuments = commonDocInitializer.getcommonProofDocuments();
		try {
			errorMsgs.addAll(fieldParser.handle(commonProofDocuments.getPanCard()));
			errorMsgs.addAll(fieldParser.handle(commonProofDocuments.getAadhar()));
			errorMsgs.addAll(fieldParser.handle(commonProofDocuments.getBankStmt()));
			errorMsgs.addAll(crossDocumentParser.handle(commonProofDocuments));
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		for (ErrorMessage string : errorMsgs) {
			logger.debug(string.getMessage());
		}
        logger.debug("Documents are validated Successfully");
    }
}
