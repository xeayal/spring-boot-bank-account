package com.user_bank_account.khayal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "com.user_bank_account.khayal.entity")
@EnableJpaRepositories(basePackages = "com.user_bank_account.khayal.repository")
public class KhayalApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhayalApplication.class, args);
	}

}
