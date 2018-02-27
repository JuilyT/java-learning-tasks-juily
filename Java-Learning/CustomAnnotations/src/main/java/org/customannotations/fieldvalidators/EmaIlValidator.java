package org.customannotations.fieldvalidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmaIlValidator implements Validator<String> {

	public boolean isValid(String value) {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");
		Matcher matcher = pattern.matcher(value);
		 if (matcher.matches()) {
		      return true;
		 }
		return false;
	}
}
