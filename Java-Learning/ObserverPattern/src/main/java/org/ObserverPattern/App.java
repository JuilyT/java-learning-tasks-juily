package org.ObserverPattern;

/**
 * 
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	//create subject
		BlogArticleSection topic = new BlogArticleSection();
		ContentTypeSection contentTypeTopic = new ContentTypeSection();
		
		//create observers
		Observer obj1 = new ArticleSubscriber("Obj1");
		Observer obj2 = new ArticleSubscriber("Obj2");
		Observer obj3 = new ArticleSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		contentTypeTopic.register(obj1);
		
		//attach observer to subject
		obj1.setBlobSection(topic);
		obj2.setBlobSection(topic);
		obj3.setBlobSection(topic);
		obj1.setBlobSection(contentTypeTopic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to blog
		topic.postMessage("New Message");
		obj1.update();
		contentTypeTopic.postMessage(ContentType.AUDIO);
		obj1.update();

    }
}
