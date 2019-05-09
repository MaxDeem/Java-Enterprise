package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.DeliveryMan;
import ru.itis.models.Order;
import ru.itis.models.User;
import ru.itis.repos.DeliveryManRepository;
import ru.itis.repos.OrderRepository;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private DeliveryManRepository deliveryManRepository;

    public OrderServiceImpl(OrderRepository orderRepository, DeliveryManRepository deliveryManRepository){
        this.orderRepository = orderRepository;
        this.deliveryManRepository = deliveryManRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
    @Override
    public List<Order> getByUser(User user) {
        return orderRepository.findByUser(user);
    }
    @Override
    public Order getOne(Long id) {
        return orderRepository.findById(id);
    }
    @Override
    public void createOrder(Order order, User user) {
        orderRepository.addOrder(order, user);
    }
    @Override
    public void editOrder(Order order) {
        orderRepository.updateOrder(order);
    }
    @Override
    public void confirmOrder(Order order, DeliveryMan deliveryMan) {
        orderRepository.updateOrderStatus(order);
        deliveryManRepository.setFree(deliveryMan);
    }
    @Override
    public void deleteByUser(User user) {
        orderRepository.deleteByUser(user);
    }
    @Override
    public void deleteOne(Long id) {
        orderRepository.deleteById(id);
    }
}
