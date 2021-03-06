package org.customannotations.fieldvalidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumberValidator implements Validator<String> {

	public boolean isValid(String value) {
		String regexStr="[\\p{Digit}&&[123456789]]+";
		Pattern pattern = Pattern.compile(regexStr);
		Matcher matcher = pattern.matcher(value); 
		 if (matcher.matches()) {
		      return true;
		 }
		return false;
	}

}
