package org.multithreading.part1;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkAndJoinTask {
	public ForkAndJoinTask () {
    }
    
    public static void main(String[] args) {
    	ForkJoinPool commonPool = ForkJoinPool.commonPool();
        List<String> lines = new CSVReader().readCSV();
        commonPool.invoke(new CustomRecursiveAction(lines));
	}
}
