package com.hackerrank.challenges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.hackerrank.challenges"})
public class ChallengesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengesApplication.class, args);
	}

}
