package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.business.AccountService;

@Configuration // Component
public class AppConfig {
  
	@Bean
	//@RefreshScope
	public AccountService accountSrv() {
		return new AccountService();
	}
}
