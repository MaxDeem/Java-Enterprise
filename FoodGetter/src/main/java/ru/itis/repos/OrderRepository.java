package ru.itis.repos;

import ru.itis.models.Order;
import ru.itis.models.User;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    List<Order> FindByUser(User user);
    Order findById(Long id);
    void addOrder(Order order);
    void updateOrderStatus();
    void deleteByUser(User user);
    void deleteById(Long id);
}
