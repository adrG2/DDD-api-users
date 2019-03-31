package com.minderest.unit.user.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.minderest.user.UserFields;
import com.minderest.user.adapter.controller.UserController;
import com.minderest.user.adapter.controller.model.UserRest;
import com.minderest.user.application.CreateUser;
import com.minderest.user.application.FindUser;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController controller;

    @Mock
    private FindUser findUser;

    @Mock
    private CreateUser createUser;

    private static final User user = User.builder().id("1").firstName(UserFields.FIRST_NAME)
	    .lastName(UserFields.LAST_NAME).email(UserFields.EMAIL).nickName(UserFields.NICK_NAME).build();

    private static final UserRest userRest = UserRest.toUserRest(user);

    @Test
    public void testFindUser() {
	Optional<User> userOpt = Optional.of(user);

	when(findUser.findById(anyString())).thenReturn(userOpt);

	UserRest response = controller.getUser("1");

	assertNotNull(response);
	assertEquals(UserFields.FIRST_NAME, response.getFirstName());
	assertEquals(UserFields.LAST_NAME, response.getLastName());
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindUserUserNotFoundException() {

	when(findUser.findById(anyString())).thenThrow(UserNotFoundException.class);

	controller.getUser("2");
    }

    @Test
    public void testCreateUser() {
	UserRest result = controller.createUser(userRest);

	assertNotNull(result);
	assertEquals(user.getFirstName(), result.getFirstName());
    }

    @Test
    public void testFindAllUsers() {
	controller.getAllUsers();
    }

}
