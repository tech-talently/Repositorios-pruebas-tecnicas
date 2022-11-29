package com.hackerrank.challenges.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hackerrank.challenges.exception.YearNotAllowedException;
import com.hackerrank.challenges.model.RequestDateAndTime;
import com.hackerrank.challenges.model.ResponseDateAndTime;
import com.hackerrank.challenges.service.DateAndTimeService;

@Service
public class DateAndTimeServiceImpl implements DateAndTimeService {

	static List<String> days = Arrays.asList("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY",
			"SATURDAY");

	@Override
	public ResponseDateAndTime execute(RequestDateAndTime date) {

		int m = date.getMonth();
		int d = date.getDay();
		int y = date.getYear();

		if (!(y > 2000 && y < 3000)) {
			throw new YearNotAllowedException(String.valueOf(y));
		}

		Calendar c = Calendar.getInstance();
		c.set(y, m - 1, d);

		int p = c.get(Calendar.DAY_OF_WEEK);
		String s = days.get(p - 1);

		return new ResponseDateAndTime(s);

	}

}
