package ru.project.service;

import ru.project.dao.UserDao;
import ru.project.entity.User;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String name, String email, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        userDao.save(new User(name, email, age));
    }
}
