package com.example.hr.domain;

import java.util.Objects;

// Object value -> immutable
public final class Fullname {

	private final String first;
	private final String last;

	private Fullname(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return this.first;
	}

	public String getLast() {
		return this.last;
	}

	public static Fullname of(String first, String last) {
		Objects.requireNonNull(first);
		Objects.requireNonNull(last);
		return new Fullname(first, last);
	}
}
