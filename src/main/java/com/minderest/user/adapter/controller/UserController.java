package com.minderest.user.adapter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minderest.user.adapter.controller.model.UserRest;
import com.minderest.user.application.CreateUser;
import com.minderest.user.application.FindUser;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserNotFoundException;

@RestController
public final class UserController {

    private FindUser findUser;
    private CreateUser createUser;

    @Autowired
    public UserController(final FindUser findUser, final CreateUser createUser) {
	this.findUser = findUser;
	this.createUser = createUser;
    }

    @GetMapping(value = "/users/{userId}")
    @ResponseBody
    public UserRest getUser(@PathVariable("userId") final String userId) {
	return UserRest.toUserRest(findUser.findById(userId).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "/users")
    public List<UserRest> allUsers() {
	return findUser.findAllUsers().stream().map(UserRest::toUserRest).collect(Collectors.toList());
    }

    @PostMapping(value = "/users")
    public UserRest createUser(@RequestBody final UserRest userRest) {
	User user = userRest.toUser();
	createUser.push(user);
	return UserRest.toUserRest(user);
    }
}
