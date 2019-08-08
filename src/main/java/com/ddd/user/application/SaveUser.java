package com.ddd.user.application;

import com.ddd.user.domain.IdGenerate;
import com.ddd.user.domain.PasswordEncoder;
import com.ddd.user.domain.User;
import com.ddd.user.domain.UserRepositoryDomainInterface;
import com.ddd.user.domain.exception.UserExistsException;

public class SaveUser {
    private final UserRepositoryDomainInterface repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerate idGenerate;

    public SaveUser(final UserRepositoryDomainInterface repository, final PasswordEncoder passwordEncoder,
	    final IdGenerate idGenerate) {
	this.repository = repository;
	this.passwordEncoder = passwordEncoder;
	this.idGenerate = idGenerate;
    }

    public void push(final User user) {
	UserValidator.validate(user);

	String email = user.getEmail();

	checkIfUserExists(email);

	User userToSave = User.builder().id(idGenerate.generate()).firstName(user.getFirstName())
		.lastName(user.getLastName()).email(email).password(passwordEncoder.encode(email + user.getPassword()))
		.nickName(user.getNickName()).build();
	repository.save(userToSave);
    }

    private void checkIfUserExists(String email) {
	repository.findByEmail(email).ifPresent(userExists -> {
	    throw new UserExistsException(email);
	});
    }

}
