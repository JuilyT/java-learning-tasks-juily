package org.Refactoring;

public class Children extends Book{
	private static final long serialVersionUID = 1L;
	private final double MULTIPLIER = 2.0;
	private final int DURATION = 3;

	public Children() {
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
