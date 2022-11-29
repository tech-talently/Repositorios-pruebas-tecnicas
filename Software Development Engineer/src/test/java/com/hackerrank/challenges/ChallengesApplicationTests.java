package com.hackerrank.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hackerrank.challenges.model.RequestCurrencyFormatter;
import com.hackerrank.challenges.model.RequestDateAndTime;
import com.hackerrank.challenges.model.ResponseCurrencyFormatter;
import com.hackerrank.challenges.model.ResponseDateAndTime;
import com.hackerrank.challenges.service.CurrencyFormatterService;
import com.hackerrank.challenges.service.DateAndTimeService;

@SpringBootTest
class ChallengesApplicationTests {

	@Autowired
	CurrencyFormatterService currencyFormatterService;

	@Autowired
	DateAndTimeService dateAndTimeService;

	@Test
	void contextLoads() {
	}

	@Test
	void currencyFormatterUs() {
		RequestCurrencyFormatter payment = new RequestCurrencyFormatter();
		payment.setPayment(123);
		ResponseCurrencyFormatter responseCurrencyFormatter = currencyFormatterService.execute(payment);
		assertThat(responseCurrencyFormatter.getUs()).isEqualTo("$123.00");
	}

	@Test
	void currencyFormatterIndia() {
		RequestCurrencyFormatter payment = new RequestCurrencyFormatter();
		payment.setPayment(123);
		ResponseCurrencyFormatter responseCurrencyFormatter = currencyFormatterService.execute(payment);
		assertThat(responseCurrencyFormatter.getIndia()).isEqualTo("Rs.123.00");
	}

	@Test
	void currencyFormatterChina() {
		RequestCurrencyFormatter payment = new RequestCurrencyFormatter();
		payment.setPayment(123);
		ResponseCurrencyFormatter responseCurrencyFormatter = currencyFormatterService.execute(payment);
		assertThat(responseCurrencyFormatter.getChina()).isEqualTo("￥123.00");
	}

	@Test
	void currencyFormatterFrance() {
		RequestCurrencyFormatter payment = new RequestCurrencyFormatter();
		payment.setPayment(123);
		ResponseCurrencyFormatter responseCurrencyFormatter = currencyFormatterService.execute(payment);
		assertThat(responseCurrencyFormatter.getFrance()).isEqualTo("123,00 €");
	}
	
	@Test
	void dateandtime() {
		RequestDateAndTime date = new RequestDateAndTime();
		date.setMonth(8);
		date.setDay(5);
		date.setYear(2015);
		ResponseDateAndTime responseDateAndTime = dateAndTimeService.execute(date);
		assertThat(responseDateAndTime.getDayWeek()).isEqualTo("WEDNESDAY");
	}

}
