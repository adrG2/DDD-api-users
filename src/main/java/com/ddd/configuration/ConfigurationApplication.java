package com.ddd.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ddd.user.application.AccessUser;
import com.ddd.user.application.SaveUser;
import com.ddd.user.application.SearchUser;
import com.ddd.user.infrastructure.repository.Seeder;

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
