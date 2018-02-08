package org.multithreading.part3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.multithreading.part2.CommonFileReader;
import org.multithreading.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoSuggest {
	private static final Logger log = LoggerFactory.getLogger(AutoSuggest.class);
	
	public static void main(String[] args) {
		List<String> sugg =autoSuggest("af");
		for (String string : sugg) {
			System.out.println(string);
		}
	}
	
	/**
	 * This class used to get the list of uto suggestions
	 * @param stringToBeSearched
	 * @return
	 */
	public static List<String> autoSuggest(String stringToBeSearched){
		log.info("Entered to check the suggestions for the string :"+stringToBeSearched);
		List<String> suggestions = new ArrayList<String>();
		try {		
			Files.lines(Paths.get(Constants.WORD_CNT_FILE))
			.filter(x -> x.split("=>")[0].indexOf(stringToBeSearched) != -1)
			.forEach(x -> suggestions.add((x.split("=>")[0])));			
		} catch (IOException e) {
			log.error("Error while reading the file :"+Constants.WORD_CNT_FILE
					+"\n Error :" +e.getMessage() );
		}
		return suggestions;
	}
}
