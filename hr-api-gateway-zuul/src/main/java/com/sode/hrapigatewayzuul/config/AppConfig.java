package com.sode.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
public class AppConfig {
	
	@Value("${jwt.secret}")
	private String signingKey; 
 
    @Bean
    JwtAccessTokenConverter accessTokenConverter() {
    	JwtAccessTokenConverter tokenConverter =  new JwtAccessTokenConverter();
    	tokenConverter.setSigningKey(signingKey);
    	return tokenConverter;
    }
    
    @Bean
    JwtTokenStore tokenStore() {
    	return new JwtTokenStore(accessTokenConverter());
    }
}