package com.minderest.user.application;

import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.ForbiddenException;
import com.minderest.user.domain.port.PasswordEncoder;
import com.minderest.user.domain.port.UserRepository;

public class LoginUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
    }

    public User login(final String email, final String password) {
	User user = userRepository.findByEmail(email).orElseThrow(ForbiddenException::new);
	String hashedPassword = passwordEncoder.encode(email + password);
	if (!user.getPassword().equals(hashedPassword))
	    throw new ForbiddenException();
	return user;
    }
}
