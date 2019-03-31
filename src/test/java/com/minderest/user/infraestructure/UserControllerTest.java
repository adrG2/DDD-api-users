package com.minderest.user.infraestructure;

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

import com.minderest.user.application.FindUser;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserNotFoundException;
import com.minderest.user.infrastructure.controller.UserController;
import com.minderest.user.infrastructure.controller.model.UserResponse;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController controller;

    @Mock
    private FindUser findUser;

    @Test
    public void testFindUser() {
	User user = User.builder().id("1").firstName("Antonio").lastName("Fernandez").email("anfer@gmail.com")
		.nickName("anfer90").build();
	Optional<User> userOpt = Optional.of(user);
	when(findUser.findById(anyString())).thenReturn(userOpt);
	UserResponse response = controller.getUser("1");
	assertNotNull(response);
	assertEquals("Antonio", response.getFirstName());
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindUserUserNotFoundException() {
	when(findUser.findById(anyString())).thenThrow(UserNotFoundException.class);
	controller.getUser("2");
    }

}
