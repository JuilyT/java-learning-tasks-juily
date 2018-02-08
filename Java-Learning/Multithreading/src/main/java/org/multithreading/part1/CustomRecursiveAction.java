package org.multithreading.part1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRecursiveAction extends RecursiveTask{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomRecursiveAction.class);
	private List<String> workload = new ArrayList<>();
    private static final int THRESHOLD = 1000;
    private static AtomicInteger counter= new AtomicInteger() ;
    
    public CustomRecursiveAction(List<String> workload) {
        this.workload = workload;
    }
    
	@Override
	protected Object compute() {
		if(workload.size() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks());
		} else {
			processing(workload);
		}
		return null;
	}
	
	private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();
        int size = workload.size();
        List<String> partOne = workload.subList(0,THRESHOLD);
        List<String> partTwo = workload.subList(THRESHOLD + 1, size);
        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));
        return subtasks;
    }
	
	private void processing(List<String> work) {
		int count = counter.incrementAndGet();
		Path out = Paths.get("/home/juilykumari/Documents/output"+"_"+count+".txt");
		try {
			List<String> arrayList = new ArrayList<> (work);
			Files.write(out,arrayList,Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		logger.info("currentThread:"+Thread.currentThread().getName()+ 
				Thread.currentThread().getState());
	}

	public AtomicInteger getCounter() {
		return counter;
	}
}
