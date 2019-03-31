package com.minderest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.minderest.user.adapter.repository.Seeder;
import com.minderest.user.application.FindUser;

@Configuration
public class ConfigurationApplication {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public FindUser findUser() {
	return config.findUser();
    }

    @Bean
    public Seeder findSeed() {
	return config.findSeed();
    }
}
