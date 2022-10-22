package com.edv.microuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestemplateConfig {

	@Bean
	public RestTemplate restemplate() {
		return new RestTemplate();
	}
}
