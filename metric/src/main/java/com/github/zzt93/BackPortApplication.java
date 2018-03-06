package com.github.zzt93;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackPortApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackPortApplication.class, "--debug");
	}

}
