package com.minderest.user.application;

import com.minderest.user.domain.IdGenerate;
import com.minderest.user.domain.PasswordEncoder;
import com.minderest.user.domain.User;
import com.minderest.user.domain.UserRepository;
import com.minderest.user.domain.exception.UserExistsException;

public class SaveUser {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerate idGenerate;

    public SaveUser(final UserRepository repository, final PasswordEncoder passwordEncoder,
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
