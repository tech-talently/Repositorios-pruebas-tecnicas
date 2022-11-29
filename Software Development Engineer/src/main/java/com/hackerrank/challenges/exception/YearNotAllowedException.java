package com.hackerrank.challenges.exception;

public class YearNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public YearNotAllowedException(String year) {
		super("Year not allowed: " + year);
	}
}
