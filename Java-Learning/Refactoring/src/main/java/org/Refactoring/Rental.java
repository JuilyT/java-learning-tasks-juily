package org.Refactoring;

/**
 * Represent a customer renting a book.
 * 
 * @author juilykumari
 *
 */
public class Rental {
	private Book book;

	private int daysRented;

	public Rental(Book book, int daysRented) {
		super();
		this.book = book;
		this.daysRented = daysRented;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	
	public Double getPrice( ) {
		return book.getPrice(getDaysRented());
	}
	
	public int addPoints() {
		return book.getPoints(getDaysRented());
	}
}
