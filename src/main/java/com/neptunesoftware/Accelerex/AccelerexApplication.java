package com.neptunesoftware.Accelerex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AccelerexApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccelerexApplication.class, args);
	}
}
