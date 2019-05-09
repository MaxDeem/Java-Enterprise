package ru.itis.services;

import ru.itis.models.DeliveryMan;
import ru.itis.models.Order;
import ru.itis.models.User;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    List<Order> getByUser(User user);
    Order getOne(Long id);
    void createOrder(Order order, User user);
    void editOrder(Order order);
    void confirmOrder(Order order, DeliveryMan deliveryMan);
    void deleteByUser(User user);
    void deleteOne(Long id);
}
