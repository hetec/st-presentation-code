package ctrl;

public enum Weight {

	ONEFOLD(1),
	TWOFOLD(2),
	THREEFOLD(3);
	
	private final int value;
	
	private Weight(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
