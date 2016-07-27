package org.pode.model;

public enum Grade {
	ONE(1.0),
	ONE_THREE(1.3),
	ONE_SEVEN(1.7),
	TWO(2.0),
	TWO_THREE(2.3),
	TWO_SEVEN(2.7),
	THREE(3.0),
	THREE_THREE(3.3),
	THREEE_SEVEN(3.7),
	FOUR(4.0),
	FIVE(5.0);
	
	private final double value;
	
	private Grade(final double value){
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
