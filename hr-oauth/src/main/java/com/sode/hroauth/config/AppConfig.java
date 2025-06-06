package com.sode.hroauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
	
	@Value("${jwt.secret}")
	private String singKey;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    JwtAccessTokenConverter accessTokenConverter() {
    	JwtAccessTokenConverter tokenConverter =  new JwtAccessTokenConverter();
    	tokenConverter.setSigningKey(singKey);
    	return tokenConverter;
    }
    
    @Bean
    JwtTokenStore tokenStore() {
    	return new JwtTokenStore(accessTokenConverter());
    }

}
