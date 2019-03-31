package com.minderest.user.application;

import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserExistsException;
import com.minderest.user.domain.port.IdGenerate;
import com.minderest.user.domain.port.PasswordEncoder;
import com.minderest.user.domain.port.UserRepository;

public class CreateUser {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerate idGenerate;

    public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder,
	    final IdGenerate idGenerate) {
	this.repository = repository;
	this.passwordEncoder = passwordEncoder;
	this.idGenerate = idGenerate;
    }

    public void save(final User user) {
	UserValidator.validate(user);

	String email = user.getEmail();

	repository.findByEmail(email).ifPresent(userExists -> {
	    throw new UserExistsException(email);
	});

	User userToSave = User.builder().id(idGenerate.generate()).firstName(user.getFirstName())
		.lastName(user.getLastName()).email(email).password(passwordEncoder.encode(email + user.getPassword()))
		.nickName(user.getNickName()).build();
	repository.save(userToSave);
    }

}
