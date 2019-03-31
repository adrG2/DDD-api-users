package com.minderest.user.application;

import java.util.List;
import java.util.Optional;

import com.minderest.user.domain.User;
import com.minderest.user.domain.UserRepository;

public class SearchUser {

    private UserRepository repository;

    public SearchUser(final UserRepository repository) {
	this.repository = repository;
    }

    public Optional<User> findById(final String id) {
	return repository.findById(id);
    }

    public List<User> findAllUsers() {
	return repository.findAllUsers();
    }
}
