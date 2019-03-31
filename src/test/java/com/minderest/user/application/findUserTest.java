package com.minderest.user.application;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.minderest.user.domain.User;
import com.minderest.user.domain.port.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class findUserTest {

    @InjectMocks
    private FindUser findUser;

    @Mock
    UserRepository userRepository;

    @Test
    public void testFindUser() {
	when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(mock(User.class)));
	Optional<User> result = findUser.findById("1");
	assertNotNull(result);
    }

    @Test
    public void testFindUserNotFoundException() {
	findUser.findById("2");
    }

}
