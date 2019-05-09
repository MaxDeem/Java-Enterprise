package ru.itis.services;

import ru.itis.models.DeliveryMan;
import ru.itis.models.Order;
import ru.itis.models.Status;

import java.util.List;

public interface DeliveryManService {
    List<DeliveryMan> getAllDeliveryMen();
    DeliveryMan getOne(Long id);
    void takeOrder(Order order, DeliveryMan deliveryMan);
    void edit(DeliveryMan deliveryMan);
}
