package ru.itis.repos;

import ru.itis.models.ProductType;

import java.util.List;

public interface ProductTypeRepository {
    List<ProductType> findAll();
    ProductType findById(Long id);
    void rename(ProductType type);
    void deleteById(Long id);
}
