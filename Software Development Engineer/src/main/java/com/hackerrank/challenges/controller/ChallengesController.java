package com.hackerrank.challenges.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.challenges.model.RequestCurrencyFormatter;
import com.hackerrank.challenges.model.RequestDateAndTime;
import com.hackerrank.challenges.model.ResponseCurrencyFormatter;
import com.hackerrank.challenges.model.ResponseDateAndTime;
import com.hackerrank.challenges.service.CurrencyFormatterService;
import com.hackerrank.challenges.service.DateAndTimeService;

@RestController
public class ChallengesController {

	@Autowired
	CurrencyFormatterService currencyFormatterService;

	@Autowired
	DateAndTimeService dateAndTimeService;

	@PostMapping("/currencyformatter")
	public ResponseCurrencyFormatter currencyformatter(@RequestBody RequestCurrencyFormatter payment) {
		return currencyFormatterService.execute(payment);
	}

	@PostMapping("/dateandtime")
	public ResponseDateAndTime dateandtime(@RequestBody RequestDateAndTime date) {
		return dateAndTimeService.execute(date);
	}

}