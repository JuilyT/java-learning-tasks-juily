package org.customannotations.fieldvalidators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator implements Validator<String>{
	final static String DATE_FORMAT = "dd-MM-yyyy";
	public boolean isValid(String date) {
		try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
	}

}
