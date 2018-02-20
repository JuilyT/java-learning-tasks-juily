package org.customannotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PanNumberValidator implements Validator<String>{

	public boolean isValid(String value) {
		Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");

		Matcher matcher = pattern.matcher(value);
		// Check if pattern matches 
		if (matcher.matches()) {
			return true;
		} 
		return false;
	}
	
}
