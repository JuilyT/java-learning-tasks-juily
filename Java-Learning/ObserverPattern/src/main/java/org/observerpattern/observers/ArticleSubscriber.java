package org.observerpattern.observers;

import org.observerpattern.enums.ContentType;
import org.observerpattern.subjects.BlogSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleSubscriber implements Observer {
	private String name;
	private BlogSection topic;
	private static final Logger logger = LoggerFactory.getLogger(ArticleSubscriber.class);
	
	public ArticleSubscriber(String nm){
		this.name=nm;
	}
	
	public void update() {
		if (topic.triggerEvent(this) instanceof String) {
			String msg = (String)topic.triggerEvent(this);
			if(msg == null){
				System.out.println(name+": No new message");
			}else
				System.out.println(name+": Consuming message:"+msg);
		} else {
			ContentType content  = (ContentType)topic.triggerEvent(this);
			if(content == null){
				System.out.println(name+": No new content");
			}else {
				System.out.println(name+": Consuming content:"+content);
			}
		}
	}

	public void setBlobSection(BlogSection sub) {
		this.topic=sub;
	}
}
