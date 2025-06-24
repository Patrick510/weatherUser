package com.user.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		System.out.println("API working fine");
		SpringApplication.run(WeatherApplication.class, args);
	}

}
