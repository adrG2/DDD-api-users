package com.minderest.api.infrastructure.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import com.minderest.api.domain.User;
import com.minderest.api.domain.UserRepository;

public class DatabaseMemory implements UserRepository {

    private final Map<String, User> db = new HashMap<>();

    @Override
    public Optional<User> findById(final String id) {
	return Optional.ofNullable(db.get(id));
    }

    @Override
    public User create(final User user) {
	db.put(user.getId(), user);
	return user;
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
