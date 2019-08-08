package com.ddd.user.application;

import java.util.List;
import java.util.Optional;

import com.ddd.user.domain.User;
import com.ddd.user.domain.UserRepositoryDomainInterface;

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
