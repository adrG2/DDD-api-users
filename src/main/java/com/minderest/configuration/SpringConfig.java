package com.minderest.configuration;

import com.minderest.user.application.FindUser;
import com.minderest.user.domain.UserRepository;
import com.minderest.user.infrastructure.repository.DatabaseMemory;
import com.minderest.user.infrastructure.repository.Seeder;

public class SpringConfig {
    private final UserRepository userRepository = new DatabaseMemory();

    public FindUser findUser() {
	return new FindUser(userRepository);
    }

    public Seeder findSeed() {
	return new Seeder(userRepository);
    }
}
