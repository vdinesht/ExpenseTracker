package com.home.expensetrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExpensetrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackApplication.class, args);
	}

}
