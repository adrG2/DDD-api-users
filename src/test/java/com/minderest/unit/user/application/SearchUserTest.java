package com.minderest.unit.user.application;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.minderest.user.application.SearchUser;
import com.minderest.user.domain.User;
import com.minderest.user.domain.UserRepositoryDomainInterface;
import com.minderest.user.domain.exception.UserNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class SearchUserTest {

    @InjectMocks
    private SearchUser searchUser;

    @Mock
    UserRepositoryDomainInterface userRepository;

    @Test
    public void testsearchUser() {
	when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(mock(User.class)));
	Optional<User> result = searchUser.findById("1");
	assertNotNull(result);
    }

    @Test(expected = UserNotFoundException.class)
    public void testsearchUserNotFoundException() {
	when(userRepository.findById(Mockito.anyString())).thenThrow(UserNotFoundException.class);
	searchUser.findById("2");
    }

    @Test
    public void testsearchUsers() {
	List<User> users = new ArrayList<>();
	when(userRepository.findAllUsers()).thenReturn(users);
	searchUser.findAllUsers();
    }

}
