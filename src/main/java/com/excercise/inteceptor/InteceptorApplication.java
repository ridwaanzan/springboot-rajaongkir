package com.excercise.inteceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application-${spring.profiles.active}.properties")
})
public class InteceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteceptorApplication.class, args);
	}

}
