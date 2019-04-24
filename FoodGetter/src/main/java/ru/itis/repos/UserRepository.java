package ru.itis.repos;

import ru.itis.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    List<User> findByStatus(Long id);
    User findById(Long id);
    void addUser(User user);
    void addShop(User user);
    void deleteById(Long id);

}
