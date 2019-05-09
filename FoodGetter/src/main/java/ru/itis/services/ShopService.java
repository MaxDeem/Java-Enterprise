package ru.itis.services;

import ru.itis.models.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAll();
    Shop getOneShop(Long id);
    Shop findShop(String name);
    void createShop(Shop shop);
    void editShop(Shop shop);
    void deleteShop(Long id);
}
