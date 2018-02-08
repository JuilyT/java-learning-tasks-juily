package org.Refactoring;

import java.util.Date;

/**
 * Simple data class representing book data
 * @author juilykumari
 *
 */
public abstract class Book {
	private static final long serialVersionUID = -7348792584072115788L;
	private Date releaseDate;
	private long id;
	private String title;
	private BookCategory bookCategory;
	private Double basePrice;
	
	public Book(final String title) {
		super();
		this.title = title;
	}
	
	public Book() {
		super();
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	
	public Double getPrice(int daysRented){
		Double thisAmount = getBasePrice();
		if (daysRented > getDuration()) {
			thisAmount += (daysRented - getDuration()) * getMultiplier();
		}
		return thisAmount;
	}
	public abstract int getPoints(int daysRented);


	public abstract double getMultiplier();

	public abstract double getDuration();

}
