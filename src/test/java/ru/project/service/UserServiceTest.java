package ru.project.service;

import org.junit.jupiter.api.Test;
import ru.project.dao.UserDao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void shouldCallDao() {
        UserDao dao = mock(UserDao.class);
        UserService service = new UserService(dao);

        service.createUser("John", "john@mail.com", 30);

        verify(dao, times(1)).save(any());
    }

    @Test
    void shouldThrowException() {
        UserDao dao = mock(UserDao.class);
        UserService service = new UserService(dao);

        assertThrows(IllegalArgumentException.class,
                () -> service.createUser("John", "mail", -1));
    }
}
