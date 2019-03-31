package com.minderest.configuration;

import com.minderest.user.application.AccessUser;
import com.minderest.user.application.SaveUser;
import com.minderest.user.application.SearchUser;
import com.minderest.user.domain.PasswordEncoder;
import com.minderest.user.domain.UserRepository;
import com.minderest.user.infrastructure.encoder.PasswordSha256;
import com.minderest.user.infrastructure.idgenerator.Uuid;
import com.minderest.user.infrastructure.repository.DatabaseMemory;
import com.minderest.user.infrastructure.repository.Seeder;

public class SpringConfig {

    public SaveUser saveUser() {
	return new SaveUser(userRepository, passwordEncoder, new Uuid());
    }

    public SearchUser searchUser() {
	return new SearchUser(userRepository);
    }

    public AccessUser accessUser() {
	return new AccessUser(userRepository, passwordEncoder);
    }

    public Seeder getSeed() {
	return new Seeder(userRepository);
    }

    private final UserRepository userRepository = new DatabaseMemory();
    private final PasswordEncoder passwordEncoder = new PasswordSha256();
}
