package com.minderest.user.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minderest.user.application.AccessUser;
import com.minderest.user.application.SaveUser;
import com.minderest.user.application.SearchUser;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserNotFoundException;
import com.minderest.user.infrastructure.controller.model.LoginUserRest;
import com.minderest.user.infrastructure.controller.model.UserRest;

@RestController
public final class Controller {

    private SearchUser searchUser;
    private SaveUser saveUser;
    private AccessUser accessUser;

    @Autowired
    public Controller(final SearchUser searchUser, final SaveUser createUser, final AccessUser loginUser) {
	this.searchUser = searchUser;
	this.saveUser = createUser;
	this.accessUser = loginUser;
    }

    @GetMapping(value = "/user/{userId}")
    @ResponseBody
    public UserRest getUser(@PathVariable("userId") final String userId) {
	return UserRest.toUserRest(searchUser.findById(userId).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "/users")
    public List<UserRest> getAllUsers() {
	return searchUser.findAllUsers().stream().map(UserRest::toUserRest).collect(Collectors.toList());
    }

    @PostMapping(value = "/user")
    public UserRest createUser(@RequestBody final UserRest userRest) {
	User user = userRest.toUser();
	saveUser.push(user);
	return UserRest.toUserRest(user);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public UserRest login(@RequestBody final LoginUserRest loginUserRest) {
	return UserRest.toUserRest(accessUser.login(loginUserRest));
    }
}
