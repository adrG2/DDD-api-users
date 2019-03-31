package com.minderest.user.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import com.minderest.user.domain.User;
import com.minderest.user.domain.UserRepositoryDomainInterface;

public final class DatabaseMemory implements UserRepositoryDomainInterface {

    private final Map<String, User> db = new HashMap<>();

    @Override
    public Optional<User> findById(final String id) {
	return Optional.ofNullable(db.get(id));
    }

    @Override
    public void save(final User user) {
	db.put(user.getId(), user);
    }

    @Override
    public Optional<User> findByEmail(final String email) {
	return db.values().stream().filter(compareEmails(email)).findAny();
    }

    private Predicate<? super User> compareEmails(final String email) {
	return user -> user.getEmail().equals(email);
    }

    @Override
    public List<User> findAllUsers() {
	return new ArrayList<>(db.values());
    }

}
