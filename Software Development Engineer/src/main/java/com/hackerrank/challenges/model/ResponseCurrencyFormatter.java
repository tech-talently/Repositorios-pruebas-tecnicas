package com.hackerrank.challenges.model;

public class ResponseCurrencyFormatter {

	private String us;

	private String india;

	private String china;

	private String france;
	
	public ResponseCurrencyFormatter(String us, String india, String china, String france) {
		this.us = us;
		this.india = india;
		this.china = china;
		this.france = france;
	}

	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	public String getIndia() {
		return india;
	}

	public void setIndia(String india) {
		this.india = india;
	}

	public String getChina() {
		return china;
	}

	public void setChina(String china) {
		this.china = china;
	}

	public String getFrance() {
		return france;
	}

	public void setFrance(String france) {
		this.france = france;
	}

}
