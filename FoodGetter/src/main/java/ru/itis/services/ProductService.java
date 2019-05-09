package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.models.ProductType;
import ru.itis.models.Shop;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getByType(ProductType type);
    List<Product> getByShop(Shop shop);
    Product getOne(Long id);
    void createProduct(Product product);
    void editProduct(Product product);
    void deleteByType(ProductType type);
    void deleteProduct(Long id);
}
