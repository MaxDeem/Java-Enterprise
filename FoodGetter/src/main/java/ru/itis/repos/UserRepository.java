package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.models.Order;
import ru.itis.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    List<User> findByStatus(Long status);
    void addUser(User user);
    void updateUser(User user);
    void deleteById(Long id);
}
