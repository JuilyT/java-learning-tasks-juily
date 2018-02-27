package org.customannotations.annotationhandlers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.customannotations.ErrorMessage;
import org.customannotations.annotations.ConsistencyCheck;
import org.customannotations.annotations.Key;
import org.customannotations.model.BackgroundCheckDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler to check consistency across all eligible documents
 * Allows generic type of verification documents for consistency check
 * @author juilykumari
 *
 */
public class ConsistencyCheckHandler implements AnnotationHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsistencyCheckHandler.class);
	
	public <T> List<ErrorMessage> handle(T docs) throws Exception {
		Field[] fields = docs.getClass().getDeclaredFields();
		List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
		Map<String, Object> fieldMap = new HashMap();
		Key annotation;
		ErrorMessage msg = null;
		for (Field field : fields) {
			Class docClass = field.getType();
			if (docClass.isAnnotationPresent(ConsistencyCheck.class)) {
				field.setAccessible(true);
				Object obj = field.get(docs);
				Field[] docFields = docClass.getDeclaredFields();
				for (Field docfield : docFields) {
					if (docfield.isAnnotationPresent(Key.class)){
						annotation = docfield.getAnnotation(Key.class);
						docfield.setAccessible(true);
						if (!fieldMap.containsKey(annotation.name())) {
							fieldMap.put(annotation.name(), docfield.get(obj));
						} else {
							if(!fieldMap.get(annotation.name()).equals(docfield.get(obj))) {
								msg = new ErrorMessage
										(fieldMap.get(annotation.name()) +" is not matching "+ 
												docfield.get(obj)+" for field: "+docfield.getName()+" in doc: "+docClass.getName(),docfield.getName());
								errors.add(msg);
							}
						}
					}
				}
			}
		}
		return errors;
	}
}
