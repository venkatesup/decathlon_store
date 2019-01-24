package com.decathlon.store;

import org.jboss.logging.*;

import org.jboss.logging.Logger.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class DecathlonStoreApplication {

	private static final Logger logger = Logger
			.getLogger(DecathlonStoreApplication.class);

	public static void main(String[] args) {

		logger.log(Level.INFO, "Decathlon Store Application");
		SpringApplication.run(DecathlonStoreApplication.class, args);
	}
}