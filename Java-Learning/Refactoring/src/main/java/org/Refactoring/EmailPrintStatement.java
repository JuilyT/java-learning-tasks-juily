package org.Refactoring;

import java.util.Iterator;

public class EmailPrintStatement implements PrintStatement{
	private Customer customer;

	public EmailPrintStatement(Customer customer) {
		this.customer = customer;
	}

	public String fetchStatement() throws Exception {
		Iterator<Rental> iterator = customer.getRentals().iterator();
		double price = 0.0;
		int frequentRenterPoints = 0;
		while (iterator.hasNext()) {
			Rental rental = iterator.next();
			rental.setBook(BookFactory.getBook(rental.getBook().getBookCategory()));
			price += rental.getBook().getPrice(rental.getDaysRented());
			frequentRenterPoints = rental.addPoints();
		}
		return new StringBuilder().append("Email Statement: ").append(price).append("You earned ")
				.append(frequentRenterPoints).append(" frequent renter points").toString();
	}
}
