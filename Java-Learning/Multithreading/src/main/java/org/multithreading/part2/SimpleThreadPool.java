package org.multithreading.part2;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleThreadPool {
	private static final Logger logger = LoggerFactory.getLogger(WikiReader.class);
	public static void main(String[] args) {
		CommonFileReader reader = new CommonFileReader();
		Set<String> wordsToBeSearched = reader.readFiles(FileFormatType.LINE_SEPARATED);
        ExecutorService executor = Executors.newFixedThreadPool(wordsToBeSearched.size()/20);
        for (String word: wordsToBeSearched) {
        	/*
        	 * Writing the WIKI extract into files for each string param. 
        	 */
            Runnable worker = new WikiReader(word);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        logger.info("Finished all threads");
    }
}
