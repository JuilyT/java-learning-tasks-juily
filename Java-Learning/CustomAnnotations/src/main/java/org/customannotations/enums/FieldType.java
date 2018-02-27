package org.customannotations.enums;

import org.customannotations.fieldvalidators.AccountNumberValidator;
import org.customannotations.fieldvalidators.DateValidator;
import org.customannotations.fieldvalidators.EmaIlValidator;
import org.customannotations.fieldvalidators.PanNumberValidator;
import org.customannotations.fieldvalidators.PhoneValidator;
import org.customannotations.fieldvalidators.StringValidator;
import org.customannotations.fieldvalidators.Validator;

public enum FieldType {
	STRING(String.class, new StringValidator()), 
	EMAIL(String.class, new EmaIlValidator()),
	PHONE_NUMBER(String.class, new PhoneValidator()),
	ACCOUNT(String.class, new AccountNumberValidator()),
	PAN_NUMBER(String.class, new PanNumberValidator()),
	DATE(String.class, new DateValidator()),
	DATE_STRING(String.class, new DateValidator());
	
	private final Class clz;
	private final Validator V;

	private <T> FieldType(Class clz, Validator<T> V) {
		this.clz = clz;
		this.V = V;
	}

	public Class getClz() {
		return clz;
	}

	public Validator getV() {
		return V;
	}

}
