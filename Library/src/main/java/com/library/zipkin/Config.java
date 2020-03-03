package com.library.zipkin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	@Bean("book")
	public RestTemplate getRest() {
		return new RestTemplate();
	}
	

}
