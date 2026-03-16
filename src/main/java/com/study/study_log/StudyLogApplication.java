package com.study.study_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudyLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyLogApplication.class, args);
	}

}
