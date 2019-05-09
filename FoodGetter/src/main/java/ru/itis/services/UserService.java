package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getOneUser(Long id);
    void editUser(User user);
    void registerUser(User user);
    void deleteUser(Long id);
}
