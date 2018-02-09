package org.multithreading.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.multithreading.utils.Constants;

public class CSVReader {
	public CSVReader() {
	}
	    
    public List<String> readCSV() {
    	List<String> lines = null;
    	try {
            BufferedReader br = Files.newBufferedReader(
            		Paths.get(Constants.IN_CSV_FILE));
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return lines;
    }
}
