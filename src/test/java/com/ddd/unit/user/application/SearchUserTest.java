package com.ddd.unit.user.application;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ddd.user.application.SearchUser;
import com.ddd.user.domain.User;
import com.ddd.user.domain.UserRepositoryDomainInterface;
import com.ddd.user.domain.exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchUserTest {

    @InjectMocks
    private SearchUser searchUser;

    @Mock
    UserRepositoryDomainInterface userRepository;

    @Test
    public void testsearchUser() {
        when(userRepository.findById(Mockito.anyString()))
            .thenReturn(Optional.of(mock(User.class)));
        Optional<User> result = searchUser.findById("1");
        assertNotNull(result);
    }

    @Test(expected = UserNotFoundException.class)
    public void testSearchUserNotFoundException() {
        when(userRepository.findById(Mockito.anyString())).thenThrow(UserNotFoundException.class);
        searchUser.findById("2");
    }

    @Test
    public void testSearchUsers() {
        List<User> users = new ArrayList<>();
        when(userRepository.findAllUsers()).thenReturn(users);
        searchUser.findAllUsers();
    }
}
