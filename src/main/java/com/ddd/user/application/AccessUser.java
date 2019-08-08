package com.ddd.user.application;

import com.ddd.shared.util.StringCheck;
import com.ddd.user.domain.PasswordEncoder;
import com.ddd.user.domain.User;
import com.ddd.user.domain.UserRepositoryDomainInterface;
import com.ddd.user.domain.exception.ForbiddenException;
import com.ddd.user.domain.exception.UserLoginBadParamsException;
import com.ddd.user.infrastructure.controller.model.LoginUserRest;

public class AccessUser {
    private final UserRepositoryDomainInterface userRepository;
    private final PasswordEncoder passwordEncoder;

    public AccessUser(final UserRepositoryDomainInterface userRepository, final PasswordEncoder passwordEncoder) {
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
    }

    public User login(final LoginUserRest loginUserRest) {
	String email = loginUserRest.getEmail();
	String password = loginUserRest.getPassword();

	validateParams(email, password);

	User user = userRepository.findByEmail(email).orElseThrow(ForbiddenException::new);
	String hashedPassword = endocePassword(email, password);

	if (checkPassword(password, hashedPassword))
	    throw new ForbiddenException("Error autenticacion");

	return user;
    }

    private void validateParams(String email, String password) {
	if (StringCheck.isBlankAnyArgument(email, password)) {
	    throw new UserLoginBadParamsException();
	}
    }

    private String endocePassword(String email, String password) {
	return passwordEncoder.encode(email + password);
    }

    private boolean checkPassword(String password, String hashedPassword) {
	return !password.equals(hashedPassword);
    }
}
