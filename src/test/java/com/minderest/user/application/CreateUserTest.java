package com.minderest.user.application;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.minderest.user.UserFields;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserExistsException;
import com.minderest.user.domain.exception.UserValidationException;
import com.minderest.user.domain.port.IdGenerate;
import com.minderest.user.domain.port.PasswordEncoder;
import com.minderest.user.domain.port.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserTest {

    @InjectMocks
    private CreateUser createUser;

    @Mock
    private UserRepository userRepository;

    @Mock
    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

    @Mock
    private final IdGenerate idGenerate = mock(IdGenerate.class);

    @Test
    public void testPushUser() {
	User user = User.builder().id("1").firstName(UserFields.FIRST_NAME).lastName(UserFields.LAST_NAME)
		.email(UserFields.EMAIL).nickName(UserFields.NICK_NAME).build();

	when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

	when(passwordEncoder.encode(anyString())).thenReturn("encoded");

	when(idGenerate.generate()).thenReturn("UUID");

	createUser.push(user);
    }

    @Test(expected = UserExistsException.class)
    public void testPushUserAlreadyExists() {
	User user = User.builder().id("1").firstName(UserFields.FIRST_NAME).lastName(UserFields.LAST_NAME)
		.email(UserFields.EMAIL).nickName(UserFields.NICK_NAME).build();

	when(userRepository.findByEmail(anyString())).thenThrow(UserExistsException.class);

	createUser.push(user);
    }

    @Test(expected = UserValidationException.class)
    public void testPushUserNotValid() {
	User user = mock(User.class);
	createUser.push(user);
    }

}
