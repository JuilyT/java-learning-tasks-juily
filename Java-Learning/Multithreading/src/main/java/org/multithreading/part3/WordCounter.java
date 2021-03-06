package org.multithreading.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.multithreading.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordCounter {
	private static String PATH = "/home/juilykumari/Documents/wiki_results";
	private static final Logger log = LoggerFactory.getLogger(WordCounter.class);

	public static void getWordCount(String folderName) {

		log.info("Entering into word count method ");

		Path tmpPath = Paths.get(Constants.WORD_CNT_TMP_FILE);
		if (Files.exists(tmpPath)) {
			try {
				Files.delete(tmpPath);
				Files.createFile(tmpPath);
			} catch (IOException e) {
				log.error("Error performing the file Operations :" + e.getMessage());
			}
		}

		try (Stream<Path> paths = Files.walk(Paths.get(folderName))) {
			paths.forEach(x -> {
				if (!x.endsWith("wiki_output")) {
					try {
						log.info("Getting the words for the file :" + x);
						//sorted it alphabetically
						Stream<String> lineStream = Files.lines(x).map(w -> w.split("\\s+")).flatMap(Arrays::stream).sorted();
						writeToFile(Constants.WORD_CNT_TMP_FILE, lineStream, StandardOpenOption.APPEND);
						log.info("Successfully written to the file :" + Constants.WORD_CNT_TMP_FILE);
					} catch (Exception e) {
						log.error("Error while writing to the file :" + e.getMessage());
					}

				}

			});

			// Word count on the top of tmp file
			Map<String, Integer> wordCounter = Files.lines(tmpPath).collect(Collectors.toList()).stream()
					.collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

			Map<String, Integer> wordCounter1 = new TreeMap<String, Integer>(wordCounter);
			String file1 = "";
			for (Map.Entry<String, Integer> map : wordCounter1.entrySet()) {
				file1 = file1 + map.getKey() + "=>" + map.getValue() + "\n";
			}
			writeToFile(Constants.WORD_CNT_FILE, file1);

		} catch (IOException e) {
			log.error("Error while streaming the files : " + e.getMessage());
		}

	}
	
	public static final void writeToFile(String fileName, Stream<String> document, StandardOpenOption option) {
		log.info(" writeToFile():  Writing the file : "+fileName);
		try {
			Files.write(Paths.get(fileName),(Iterable<String>) document::iterator,option);
			log.info(" writeToFile(): Successfully completed in writing the file : "+fileName);
		} catch (IOException e) {
			log.error("writeToFile():  Error while writing the file : "+fileName+"\n"
					+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void writeToFile(String fileName, String document) {
		log.info("Writing the file : "+fileName);
		try {
			Files.write(Paths.get(fileName), document.getBytes());
			log.info(" writeToFile() Stream: Successfully completed in writing the file : "+fileName);
		} catch (IOException e) {
			log.error("writeToFile() Stream:  Error while writing the file : "+fileName+e.getMessage());
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		getWordCount(PATH);		
	}
}
