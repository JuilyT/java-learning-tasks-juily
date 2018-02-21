package org.observerpattern.observers;

import org.observerpattern.subjects.BlogSection;

public interface Observer {
	//method to update the observer, used by subject
	public void update();
	//attach with subject to observe
	public void setBlobSection(BlogSection section);
	
}
