package com.tsuds.backend_app_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication()
@EnableAutoConfiguration
public class BackendAppSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAppSecurityApplication.class, args);
	}

}
