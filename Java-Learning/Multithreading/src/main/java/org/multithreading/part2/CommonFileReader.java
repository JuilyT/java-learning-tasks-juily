package org.multithreading.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * To Read words from text input files and generating WIKI files out of it.
 * @author juilykumari
 *
 */
public class CommonFileReader {
	public Set<String> readFiles(FileFormatType formatType) {
		return readFileIntoList(formatType);			
	}
	
	protected Set<String> readFileIntoList(FileFormatType fileFormat) {
		Set<String> lines = new HashSet<>();
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("/home/juilykumari/Downloads/"+fileFormat.getFileName()));
			String line;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(fileFormat.getDelimiter());
			     for (String str : values) {
			        if(str.length()>0){	lines.add(str.trim());}
			     }
			}
			reader.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return lines;
	}
}
