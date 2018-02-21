package org.observerpattern.subjects;

import java.util.ArrayList;
import java.util.List;

import org.observerpattern.observers.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogArticleSection implements BlogSection{
	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	private ContentTypeSection contentTypeSection;
	private static final Logger logger = LoggerFactory.getLogger(BlogArticleSection.class);
	
	public BlogArticleSection(){
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
	
	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public Object triggerEvent(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		System.out.println("Message Posted to BlogArticleSection:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

	public ContentTypeSection getContentType() {
		return contentTypeSection;
	}

	public void setContentType(ContentTypeSection contentType) {
		this.contentTypeSection = contentType;
	}
}
