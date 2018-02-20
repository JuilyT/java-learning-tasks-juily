package org.customannotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator implements Validator<String>{

	public boolean isValid(String value) {
		Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");

		Matcher matcher = pattern.matcher(value);
		// Check if pattern matches 
		if (matcher.matches()) {
			return true;
		} 
		return false;
	}

}
