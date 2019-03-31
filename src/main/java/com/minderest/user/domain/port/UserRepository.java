package com.minderest.user.domain.port;

import java.util.List;
import java.util.Optional;

import com.minderest.user.domain.User;

public interface UserRepository {

    Optional<User> findById(String id);

    void save(User user);

    Optional<User> findByEmail(String email);

    List<User> findAllUsers();
}
