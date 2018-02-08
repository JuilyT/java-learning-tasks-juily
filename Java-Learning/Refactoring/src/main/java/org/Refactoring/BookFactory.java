package org.Refactoring;

public class BookFactory {
	public static Book getBook(BookCategory category) throws Exception {
		switch(category) {
			case FICTION:
				return new Fiction();
			case NON_FICTION:
				return new NonFiction();
			case CHILDRENS:
				return new Children();
			default:
				throw new Exception("Invalid Category");
		}
	}
}
