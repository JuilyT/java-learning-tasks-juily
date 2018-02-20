package org.customannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentsConsistencyCheck {
	String message() default "values do not match in all documents provided";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
