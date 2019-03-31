package com.minderest.user.infrastructure.repository;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.minderest.user.domain.User;
import com.minderest.user.domain.UserRepository;

public class Seeder {

    private UserRepository repository;

    public Seeder(final UserRepository repository) {
	this.repository = repository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
	seedUsersTable();
    }

    private void seedUsersTable() {
	User user = User.builder().id("1").firstName("Antonio").lastName("Fernandez").email("anfer@gmail.com")
		.nickName("anfer90").build();
	repository.save(user);
    }
}
