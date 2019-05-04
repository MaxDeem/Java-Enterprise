package ru.itis.repos;

import ru.itis.models.DeliveryMan;

import java.util.List;

public interface DeliveryManRepository {
    List<DeliveryMan> findByStatus(Long id);
    DeliveryMan findById(Long id);
    void addDeliverer(DeliveryMan user);
    void updateDeliverer(DeliveryMan user);
    void deleteById(Long id);

}
