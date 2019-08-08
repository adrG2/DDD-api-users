package com.ddd.unit.user.adapter;

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

import com.ddd.unit.util.UserFields;
import com.ddd.user.application.SaveUser;
import com.ddd.user.application.SearchUser;
import com.ddd.user.domain.User;
import com.ddd.user.domain.exception.UserNotFoundException;
import com.ddd.user.infrastructure.controller.Controller;
import com.ddd.user.infrastructure.controller.model.UserRest;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private SearchUser searchUser;

    @Mock
    private SaveUser saveUser;

    private static final User user = User.builder().id("1").firstName(UserFields.FIRST_NAME)
	    .lastName(UserFields.LAST_NAME).email(UserFields.EMAIL).nickName(UserFields.NICK_NAME).build();

    private static final UserRest userRest = UserRest.toUserRest(user);

    @Test
    public void testSearchUser() {
	Optional<User> userOpt = Optional.of(user);

	when(searchUser.findById(anyString())).thenReturn(userOpt);

	UserRest response = controller.getUser("1");

	assertNotNull(response);
	assertEquals(UserFields.FIRST_NAME, response.getFirstName());
	assertEquals(UserFields.LAST_NAME, response.getLastName());
    }

    @Test(expected = UserNotFoundException.class)
    public void testSearchUserUserNotFoundException() {

	when(searchUser.findById(anyString())).thenThrow(UserNotFoundException.class);

	controller.getUser("2");
    }

    @Test
    public void testSaveUser() {
	UserRest result = controller.createUser(userRest);

	assertNotNull(result);
	assertEquals(user.getFirstName(), result.getFirstName());
    }

    @Test
    public void testFindAllUsers() {
	controller.getAllUsers();
    }

}
