package com.mood.Moodania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.mood.Moodania.dataAccess", "com.mood.Moodania.application" , "com.mood.Moodania.presentation"} )
@EnableJpaRepositories(basePackages={"com.mood.Moodania.dataAccess"})
@EntityScan("com.mood.Moodania")

public class MoodaniaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoodaniaApplication.class, args);
	}

}
