package org.multithreading.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.multithreading.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is responsible for writing WIKI extract for each String param in separate file
 * @author juilykumari
 *
 */
public class WikiReader implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(WikiReader.class);
	private static String filePath = "/home/juilykumari/Documents/wiki_results/wiki_";
	private String wordToBeSearched;
	
	public WikiReader(String s){
        this.wordToBeSearched=s;
    }

	@Override
	public void run() {
		logger.debug(Thread.currentThread().getName()+" Start.");
		logger.info("Thread running for string: "+wordToBeSearched);
		try {
			Path out = null;
			String fileName = wordToBeSearched.replace(' ', '_');
			out = Paths.get(filePath+fileName+".txt");
			String encodedUrl = null;
			// Encoded URL with UTF-8
			encodedUrl = URLEncoder.encode(wordToBeSearched, "UTF-8");
			URL wikiUrl = new URL(Constants.WIKI_URL+encodedUrl);
	        URLConnection con = wikiUrl.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                         con.getInputStream()));
	        List<String> result = new ArrayList<>();
	        result.add(fetchExtract(in.readLine()));
	        in.lines().map(line->fetchExtract(line)).collect(Collectors.toList());
	        in.close();				
			Files.write(out,result,Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} 
        processCommand();
        logger.debug(Thread.currentThread().getName()+" End.");		
	}
	
	/*
	 * Fetching the extract out of JSON reponse of WIKI call.
	 */
	private String fetchExtract(String inputString) {
		ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> json = null;
		try {
			json = mapper.readValue(inputString, new TypeReference<Map<String, Object>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}      
        Map<String, Object> query = (Map<String, Object>)json.get("query");
        Map<String, Object> pages = (Map<String, Object>)query.get("pages");

        for (String key: pages.keySet()) {
            Map<String, Object> page = (Map<String, Object>) pages.get(key);
            String extract = page.get("extract") == null ? "" : page.get("extract").toString();
            return extract;
        }
		return inputString;
	}
	
	private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
