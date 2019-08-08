package com.ddd.configuration;

import com.ddd.user.application.AccessUser;
import com.ddd.user.application.SaveUser;
import com.ddd.user.application.SearchUser;
import com.ddd.user.domain.PasswordEncoder;
import com.ddd.user.domain.UserRepositoryDomainInterface;
import com.ddd.user.infrastructure.encoder.PasswordSha256;
import com.ddd.user.infrastructure.idgenerator.Uuid;
import com.ddd.user.infrastructure.repository.DatabaseMemory;
import com.ddd.user.infrastructure.repository.Seeder;

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

    private final UserRepositoryDomainInterface userRepository = new DatabaseMemory();
    private final PasswordEncoder passwordEncoder = new PasswordSha256();
}
