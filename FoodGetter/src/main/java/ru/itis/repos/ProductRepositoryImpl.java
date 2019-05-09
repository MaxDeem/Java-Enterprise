package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.Product;
import ru.itis.models.ProductType;
import ru.itis.models.Shop;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    //language = sql
    private static final String FIND_ALL = "SELECT product.name, price, product_type.name AS type FROM product " +
            "JOIN product_type on product.id = product_type.id;";
    //language = sql
    private static final String FIND_BY_TYPE = "SELECT name, price FROM product WHERE type_id = ?";
    //language = sql
    private static final String FIND_BY_SHOP = "SELECT product.name, price, product_type.name AS type FROM product " +
            "JOIN product_type on product.id = product_type.id WHERE shop_id = ?;";
    //language = sql
    private static final String FIND_BY_ID = "SELECT product.name, price, product_type.name AS type FROM product " +
            "JOIN product_type on product.id = product_type.id WHERE id = ?;";
    //language = sql
    private static final String ADD_PRODUCT = "INSERT INTO product (name, price, type_id, shop_id) VALUES (?, ?, ?, ?);";
    //language = sql
    private static final String EDIT = "UPDATE product SET name = ?, price = ?, type_id = ? WHERE id = ?;";
    //language = sql
    private static final String DELETE_BY_TYPE = "DELETE FROM product WHERE type_id = ?;";
    //language = sql
    private static final String DELETE_BY_ID = "DELETE FROM product WHERE id = ?;";

    JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductRepositoryImpl(DriverManagerDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    RowMapper<Product> rowMapper = (resultSet, i) -> Product.builder()
            .name(resultSet.getString("name"))
            .price(resultSet.getDouble("price"))
            .build();


    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
    @Override
    public List<Product> findByType(ProductType type) {
        return jdbcTemplate.query(FIND_BY_TYPE, rowMapper, type.getId());
    }
    @Override
    public List<Product> findByShop(Shop shop) {
        return jdbcTemplate.query(FIND_BY_SHOP, rowMapper, shop.getId());
    }
    @Override
    public Product findById(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, rowMapper, id);
    }
    @Override
    public void addProduct(Product item) {
        jdbcTemplate.update(ADD_PRODUCT, item.getName(), item.getPrice(), item.getType().getId(), item.getShop().getId());
    }
    @Override
    public void edit(Product item) {
        jdbcTemplate.update(EDIT, item.getName(), item.getPrice(), item.getType().getId());
    }
    @Override
    public void deleteByType(ProductType type) {
        jdbcTemplate.update(DELETE_BY_TYPE, type.getId());
    }
    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
