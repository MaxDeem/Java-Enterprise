package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.Shop;
import ru.itis.repos.ShopRepository;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }
    @Override
    public Shop getOneShop(Long id) {
        return shopRepository.findById(id);
    }
    @Override
    public Shop findShop(String name) {
        return shopRepository.findByName(name);
    }
    @Override
    public void createShop(Shop shop) {
        shopRepository.addShop(shop);
    }
    @Override
    public void editShop(Shop shop) {
        shopRepository.edit(shop);
    }
    @Override
    public void deleteShop(Long id) {
        shopRepository.delete(id);
    }
}
