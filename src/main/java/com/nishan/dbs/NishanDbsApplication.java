package com.nishan.dbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NishanDbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NishanDbsApplication.class, args);
	}

}
