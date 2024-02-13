package com.bridgelabz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
@EnableWebFlux
public class LearningManagementSystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LearningManagementSystemApplication.class, args);
	}

}
