package com.example.hr.domain;

public final class Money {

	private final double value;
	private final FiatCurrency currency;

	private Money(double value, FiatCurrency currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	}

	public FiatCurrency getCurrency() {
		return this.currency;
	}

	public static Money of(double value) {
		return of(value, FiatCurrency.TRY);
	}

	public static Money of(double value, FiatCurrency currency) {
		if (value < 0.)
			throw new IllegalArgumentException("money cannot be negative.");
		return new Money(value, currency);
	}

	@Override
	public String toString() {
		return value + " " + currency.name();
	}

}
