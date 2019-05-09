package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.DeliveryMan;
import ru.itis.models.Order;
import ru.itis.models.Status;
import ru.itis.repos.DeliveryManRepository;
import ru.itis.repos.OrderRepository;

import java.util.List;

@Service
public class DeliveryManServiceImpl implements DeliveryManService {
    private DeliveryManRepository deliveryManRepository;
    private OrderRepository orderRepository;

    public DeliveryManServiceImpl(DeliveryManRepository deliveryManrepository, OrderRepository orderRepository) {
        this.deliveryManRepository = deliveryManrepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<DeliveryMan> getAllDeliveryMen() {
        return deliveryManRepository.findAll();
    }
    @Override
    public DeliveryMan getOne(Long id) {
        return deliveryManRepository.findById(id);
    }
    @Override
    public void takeOrder(Order order, DeliveryMan deliveryMan) {
        orderRepository.updateDeliverer(order, deliveryMan);
        deliveryManRepository.setBusy(deliveryMan);
    }
    @Override
    public void edit(DeliveryMan deliveryMan) {
        deliveryManRepository.updateDeliverer(deliveryMan);
    }
}
