package ru.itis.repos;

import ru.itis.models.DeliveryMan;
import ru.itis.models.Order;
import ru.itis.models.User;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    List<Order> findByUser(User user);
    Order findById(Long id);
    List<Order> findOrdered();
    void addOrder(Order order, User user);
    void updateDeliverer(Order order, DeliveryMan deliveryMan);
    void updateOrder(Order order);
    void updateOrderStatus(Order order);
    void deleteByUser(User user);
    void deleteById(Long id);
}
