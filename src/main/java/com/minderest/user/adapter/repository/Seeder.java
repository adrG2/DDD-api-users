package com.minderest.user.adapter.repository;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.minderest.user.domain.User;
import com.minderest.user.domain.port.UserRepository;

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
		.nickName("anfer90").password("1234").build();
	repository.save(user);
    }
}
