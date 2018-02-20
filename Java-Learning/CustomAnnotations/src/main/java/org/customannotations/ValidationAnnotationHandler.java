package org.customannotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Handler for the field level annotations.
 * @author juilykumari
 *
 */
public class ValidationAnnotationHandler {
	public List<ErrorMessage> handle(Object ob) throws Exception {
		List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
        Field[] fields = ob.getClass().getDeclaredFields();
        ErrorMessage msg ;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Validate.class)) {              
            	Validate myAnn = field.getAnnotation(Validate.class);
            	field.setAccessible(true);
            	
            	Validator v = myAnn.id().getV();
            	if (!v.isValid(field.get(ob))) {
            		msg = new ErrorMessage(field.get(ob).toString()+" is not valid and as per "+ 
            				v.getClass().getName(),field.get(ob));
            		errors.add(msg);
				}
            }
        }
		return errors;
	}
}
