package com.minderest.configuration;

import com.minderest.user.adapter.encoder.PasswordSha256;
import com.minderest.user.adapter.idgenerator.Uuid;
import com.minderest.user.adapter.repository.DatabaseMemory;
import com.minderest.user.adapter.repository.Seeder;
import com.minderest.user.application.CreateUser;
import com.minderest.user.application.FindUser;
import com.minderest.user.application.LoginUser;
import com.minderest.user.domain.port.PasswordEncoder;
import com.minderest.user.domain.port.UserRepository;

public class SpringConfig {
    private final UserRepository userRepository = new DatabaseMemory();
    private final PasswordEncoder passwordEncoder = new PasswordSha256();

    public CreateUser createUser() {
	return new CreateUser(userRepository, passwordEncoder, new Uuid());
    }

    public FindUser findUser() {
	return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
	return new LoginUser(userRepository, passwordEncoder);
    }

    public Seeder findSeed() {
	return new Seeder(userRepository);
    }
}
