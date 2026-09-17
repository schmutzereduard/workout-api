package com.resolvedd.workoutapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:jdbc.properties")
public class WorkoutApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutApiApplication.class, args);
	}

}
