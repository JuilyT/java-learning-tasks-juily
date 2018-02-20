package org.ObserverPattern;

public interface BlogSection {
	//methods to register and unregister observers
	void register(Observer obj);
	void unregister(Observer obj);
	//method to get updates from subject
	Object triggerEvent(Observer obj);	
	//method to notify observers of change
	public void notifyObservers();
}
