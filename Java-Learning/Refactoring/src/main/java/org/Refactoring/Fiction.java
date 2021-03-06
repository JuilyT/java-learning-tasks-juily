package org.Refactoring;

public class Fiction extends Book {
	private final Double MULTIPLIER = 1.5;
	private final int DURATION = 2;
	
	public Fiction() {
		super();
	}

	@Override
	public int getPoints(int daysRented) {
		if (daysRented > 1) {
			return 2;
		}
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
