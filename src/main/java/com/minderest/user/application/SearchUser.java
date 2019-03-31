package com.minderest.user.application;

import java.util.List;
import java.util.Optional;

import com.minderest.user.domain.User;
import com.minderest.user.domain.UserRepositoryDomainInterface;

public class SearchUser {

    private UserRepositoryDomainInterface repository;

    public SearchUser(final UserRepositoryDomainInterface repository) {
	this.repository = repository;
    }

    public Optional<User> findById(final String id) {
	return repository.findById(id);
    }

    public List<User> findAllUsers() {
	return repository.findAllUsers();
    }
}
