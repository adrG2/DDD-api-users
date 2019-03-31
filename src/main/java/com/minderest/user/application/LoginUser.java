package com.minderest.user.application;

import com.minderest.shared.util.StringCheck;
import com.minderest.user.adapter.controller.model.LoginUserRest;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.ForbiddenException;
import com.minderest.user.domain.exception.UserLoginBadParamsException;
import com.minderest.user.domain.port.PasswordEncoder;
import com.minderest.user.domain.port.UserRepository;

public class LoginUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
    }

    public User login(final LoginUserRest loginUserRest) {
	String email = loginUserRest.getEmail();
	String password = loginUserRest.getPassword();

	validateParams(email, password);

	User user = userRepository.findByEmail(email).orElseThrow(ForbiddenException::new);
	String hashedPassword = endocePassword(email, password);

	if (checkPassword(user, hashedPassword))
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

    private boolean checkPassword(User user, String hashedPassword) {
	return !user.getPassword().equals(hashedPassword);
    }
}
