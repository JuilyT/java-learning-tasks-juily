package org.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogWhitePaperSection implements BlogSection {
	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	private static final Logger logger = LoggerFactory.getLogger(BlogWhitePaperSection.class);
	
	public BlogWhitePaperSection(){
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
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed) {
				return;
			}
			observersLocal = new ArrayList<Observer>();
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}
	
	public Object triggerEvent(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		logger.info("Message Posted to BlogWhitePaperSection:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

}
