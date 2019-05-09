package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;

    @Override
    public List<User> getAllUsers() {
        return null;
    }
    @Override
    public User getOneUser(Long id) {
        return null;
    }
    @Override
    public void editUser(User user) {

    }
    @Override
    public void registerUser(User user) {

    }
    @Override
    public void deleteUser(Long id) {

    }
}
