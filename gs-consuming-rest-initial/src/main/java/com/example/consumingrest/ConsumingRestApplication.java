package com.example.consumingrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;// sending msg to log/ console
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;// processes incoming data using Jackson
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;// to run the Rest Template


@SpringBootApplication
public class ConsumingRestApplication {
	// creating logger
	private static final Logger log=LoggerFactory.getLogger(ConsumingRestApplication.class);
	// main method
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}
	// injecting beans
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args->{
			Quote quote=restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}
