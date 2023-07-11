package com.luisgal.project.worklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
public class WorkListApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkListApplication.class, args);
	}

}
