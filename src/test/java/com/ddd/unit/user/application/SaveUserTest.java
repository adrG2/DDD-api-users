package com.ddd.unit.user.application;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ddd.unit.util.UserFields;
import com.ddd.user.application.SaveUser;
import com.ddd.user.domain.IdGenerate;
import com.ddd.user.domain.PasswordEncoder;
import com.ddd.user.domain.User;
import com.ddd.user.domain.UserRepositoryDomainInterface;
import com.ddd.user.domain.exception.UserExistsException;
import com.ddd.user.domain.exception.UserValidationException;

@RunWith(MockitoJUnitRunner.class)
public class SaveUserTest {

    @InjectMocks
    private SaveUser saveUser;

    @Mock
    private UserRepositoryDomainInterface userRepository;

    @Mock
    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

    @Mock
    private final IdGenerate idGenerate = mock(IdGenerate.class);

    private static final User user = User.builder().id("1").firstName(UserFields.FIRST_NAME)
	    .lastName(UserFields.LAST_NAME).email(UserFields.EMAIL).nickName(UserFields.NICK_NAME).build();

    @Test
    public void testPushUser() {

	when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

	when(passwordEncoder.encode(anyString())).thenReturn("encoded");

	when(idGenerate.generate()).thenReturn("UUID");

	saveUser.push(user);
    }

    @Test(expected = UserExistsException.class)
    public void testPushUserAlreadyExists() {

	when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));

	saveUser.push(user);
    }

    @Test(expected = UserValidationException.class)
    public void testPushUserNotValid() {
	User user = mock(User.class);
	saveUser.push(user);
    }

}
