package com.minderest.configuration;

import com.minderest.user.adapter.repository.DatabaseMemory;
import com.minderest.user.adapter.repository.Seeder;
import com.minderest.user.application.FindUser;
import com.minderest.user.domain.port.UserRepository;

public class SpringConfig {
    private final UserRepository userRepository = new DatabaseMemory();

    public FindUser findUser() {
	return new FindUser(userRepository);
    }

    public Seeder findSeed() {
	return new Seeder(userRepository);
    }
}
