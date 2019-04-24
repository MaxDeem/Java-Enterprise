package ru.itis.repos;

import ru.itis.models.Product;
import ru.itis.models.ProductType;
import ru.itis.models.Shop;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    List<Product> findByType(ProductType type);
    List<Product> findByShop(Shop shop);
    Product findById(Long id);
    void addProduct(Product item);
    void edit(Product item);
    void deleteByType(ProductType type);
    void deleteById(Long id);
}
