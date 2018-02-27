package org.customannotations.annotationhandlers;

import java.util.List;

import org.customannotations.ErrorMessage;
import org.customannotations.model.BackgroundCheckDoc;

public interface AnnotationHandler {
	<T> List<ErrorMessage> handle(T docs) throws Exception;
}
