package com.example.hr.domain;

// Value Object
public final class Iban {
	private final String value;

	private Iban(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Iban valueOf(String value) {
		if (!isValid(value))
			throw new IllegalArgumentException(value + " is not a valid identiy no.");
		return new Iban(value);
	}

	private static boolean isValid(String value2) {
		return true;
	}

	@Override
	public String toString() {
		return value;
	}

}
