package com.rafael_test.ApiJavaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.rafael_test.ApiJavaRest.repository")
@EntityScan("com.rafael_test.ApiJavaRest.model")
public class ApiJavaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJavaRestApplication.class, args);
	}

}
