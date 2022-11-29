package com.hackerrank.challenges.service;

import com.hackerrank.challenges.model.RequestCurrencyFormatter;
import com.hackerrank.challenges.model.ResponseCurrencyFormatter;

public interface CurrencyFormatterService {

	public abstract ResponseCurrencyFormatter execute(RequestCurrencyFormatter payment);

}
