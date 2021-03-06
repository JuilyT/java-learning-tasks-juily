package org.Refactoring;

public class NonFiction extends Book {
	private final double MULTIPLIER = 3.0;
	private final int DURATION = 0;

	public NonFiction(String title) {
		super(title);
	}
	
	public NonFiction() {
		super();
	}

	@Override
	public int getPoints(int daysRented) {
		return 1;
	}

	@Override
	public double getMultiplier() {
		return MULTIPLIER;
	}

	@Override
	public double getDuration() {
		return DURATION;
	}
}
