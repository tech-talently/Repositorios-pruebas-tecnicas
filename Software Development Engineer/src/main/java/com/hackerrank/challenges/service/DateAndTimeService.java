package com.hackerrank.challenges.service;

import com.hackerrank.challenges.model.RequestDateAndTime;
import com.hackerrank.challenges.model.ResponseDateAndTime;;

public interface DateAndTimeService {

	public abstract ResponseDateAndTime execute(RequestDateAndTime date);

}
