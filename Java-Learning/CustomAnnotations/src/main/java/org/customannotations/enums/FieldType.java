package org.customannotations.enums;

import java.util.Date;

import org.customannotations.AccountNumberValidator;
import org.customannotations.DateValidator;
import org.customannotations.EmaIlValidator;
import org.customannotations.PanNumberValidator;
import org.customannotations.PhoneValidator;
import org.customannotations.StringValidator;
import org.customannotations.Validator;

public enum FieldType {
	NAME(String.class, new StringValidator()), 
	EMAIL(String.class, new EmaIlValidator()),
	PHONE_NUMBER(String.class, new PhoneValidator()),
	ACCOUNT(String.class, new AccountNumberValidator()),
	PAN_NUMBER(String.class, new PanNumberValidator()),
	DATE(String.class, new DateValidator());
	
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
