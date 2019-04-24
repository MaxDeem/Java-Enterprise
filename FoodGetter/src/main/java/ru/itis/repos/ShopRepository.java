package ru.itis.repos;

import ru.itis.models.Shop;

import java.util.List;

public interface ShopRepository {
    List<Shop> findAll();
    Shop findById(Long id);
    Shop findByName(String name);
    void addShop(Shop shop);
    void edit(Shop shop);
    void delete(Long id);
}
