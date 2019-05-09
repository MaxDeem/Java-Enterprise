package ru.itis.repos;

import ru.itis.models.DeliveryMan;

import java.util.List;

public interface DeliveryManRepository {
    List<DeliveryMan> findAll();
    List<DeliveryMan> findByStatus(Long id);
    DeliveryMan findById(Long id);
    void addDeliverer(DeliveryMan user);
    void setBusy(DeliveryMan deliveryMan);
    void setFree(DeliveryMan deliveryMan);
    void updateDeliverer(DeliveryMan user);
    void deleteById(Long id);
}
