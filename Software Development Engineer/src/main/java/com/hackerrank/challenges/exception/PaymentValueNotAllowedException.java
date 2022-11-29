package com.hackerrank.challenges.exception;

public class PaymentValueNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PaymentValueNotAllowedException(String value) {
		super("Payment value not allowed: " + value);
	}
}
