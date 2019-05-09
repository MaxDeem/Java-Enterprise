package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.Product;
import ru.itis.models.ProductType;
import ru.itis.models.Shop;
import ru.itis.repos.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    @Override
    public List<Product> getByType(ProductType type) {
        return productRepository.findByType(type);
    }
    @Override
    public List<Product> getByShop(Shop shop) {
        return productRepository.findByShop(shop);
    }
    @Override
    public Product getOne(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public void createProduct(Product product) {
        productRepository.addProduct(product);
    }
    @Override
    public void editProduct(Product product) {
        productRepository.edit(product);
    }
    @Override
    public void deleteByType(ProductType type) {
        productRepository.deleteByType(type);
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
