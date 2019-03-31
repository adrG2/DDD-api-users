package com.minderest.user.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minderest.user.application.FindUser;
import com.minderest.user.domain.exception.UserNotFoundException;
import com.minderest.user.infrastructure.controller.model.UserResponse;

@RestController
public final class UserController {

    private FindUser findUser;

    @Autowired
    public UserController(final FindUser findUser) {
	this.findUser = findUser;
    }

    @GetMapping(value = "/users/{userId}")
    @ResponseBody
    public UserResponse getUser(@PathVariable("userId") final String userId) {
	return UserResponse.toUserResponse(findUser.findById(userId).orElseThrow(UserNotFoundException::new));
    }
}
