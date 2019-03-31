package com.minderest.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryDomainInterface {

    Optional<User> findById(String id);

    void save(User user);

    Optional<User> findByEmail(String email);

    List<User> findAllUsers();
}
