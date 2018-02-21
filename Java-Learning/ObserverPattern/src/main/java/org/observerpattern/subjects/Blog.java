package org.observerpattern.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.observerpattern.observers.Observer;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blog implements BlogSection {
	List<Observer> observers;
	BlogArticleSection articleSection;
	BlogCaseStudySection caseStudySection;
	BlogWhitePaperSection whitePaperSection;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	private ContentTypeSection contentTypeSection;
	private static final Logger logger = LoggerFactory.getLogger(BlogArticleSection.class);
	
	public Blog(){
		this.observers=new ArrayList<Observer>();
	}
	
	public void register(Observer obj) {
		if(obj == null) {
			throw new NullPointerException("Null Observer");
		}
		synchronized (MUTEX) {
			if(!observers.contains(obj)) {
				observers.add(obj);
			}
		}
	}

	public void unregister(Observer obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	public void notifyObservers() {
		List<Observer> observersLocal = this.observers;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed) {
				return;
			}
			this.changed=false;
		}
		Reflections reflections = new Reflections("com.mycompany");    
		Set<Class<? extends BlogSection>> classes = reflections.getSubTypesOf(BlogSection.class);
		for (Observer obj : observersLocal) {
			obj.update();
		}
	}
	
	public Object triggerEvent(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		System.out.println("Message Posted to Blog:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}
}
