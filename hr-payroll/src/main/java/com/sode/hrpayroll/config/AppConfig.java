package com.sode.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("AppConfig")
public class AppConfig {

    @Bean
    RestTemplate getRestTemplate() {
		return new RestTemplate();
		
	}

}
