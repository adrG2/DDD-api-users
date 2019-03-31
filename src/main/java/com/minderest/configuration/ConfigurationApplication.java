package com.minderest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.minderest.user.application.AccessUser;
import com.minderest.user.application.SaveUser;
import com.minderest.user.application.SearchUser;
import com.minderest.user.infrastructure.repository.Seeder;

@Configuration
public class ConfigurationApplication {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public SearchUser searchUser() {
	return config.searchUser();
    }

    @Bean
    public SaveUser saveUser() {
	return config.saveUser();
    }

    @Bean
    public AccessUser loginUser() {
	return config.accessUser();
    }

    @Bean
    public Seeder findSeed() {
	return config.getSeed();
    }
}
