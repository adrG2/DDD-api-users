package com.minderest.api.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(String id);

    User create(User user);

    Optional<User> findByEmail(String email);

    List<User> findAllUsers();
}
