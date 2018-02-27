package org.ObserverPattern;

import org.observerpattern.enums.ContentType;
import org.observerpattern.observers.ArticleSubscriber;
import org.observerpattern.observers.Observer;
import org.observerpattern.subjects.Blog;
import org.observerpattern.subjects.BlogArticleSection;
import org.observerpattern.subjects.ContentTypeSection;

/**
 * 
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	//create subject
    	Blog blogTopic = new Blog();
		BlogArticleSection topic = new BlogArticleSection();
		ContentTypeSection contentTypeTopic = new ContentTypeSection();
		
		//create observers
		Observer obj1 = new ArticleSubscriber("Obj1");
		Observer obj2 = new ArticleSubscriber("Obj2");
		Observer obj3 = new ArticleSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		contentTypeTopic.register(obj2);
		blogTopic.register(obj3);
		
		//attach observer to subject
		obj1.setBlobSection(topic);
		obj2.setBlobSection(contentTypeTopic);
		obj3.setBlobSection(blogTopic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to blog
		topic.postMessage("New Message");
		obj1.update();
		contentTypeTopic.postMessage(ContentType.AUDIO);
		obj2.update();
		blogTopic.postMessage("hfjghgj");

    }
}
