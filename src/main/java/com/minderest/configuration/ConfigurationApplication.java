package com.minderest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.minderest.user.adapter.repository.Seeder;
import com.minderest.user.application.CreateUser;
import com.minderest.user.application.FindUser;
import com.minderest.user.application.LoginUser;

@Configuration
public class ConfigurationApplication {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public FindUser findUser() {
	return config.findUser();
    }

    @Bean
    public CreateUser createUser() {
	return config.createUser();
    }

    @Bean
    public LoginUser loginUser() {
	return config.loginUser();
    }

    @Bean
    public Seeder findSeed() {
	return config.findSeed();
    }
}
