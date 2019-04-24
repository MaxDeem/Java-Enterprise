package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.Shop;

import java.util.List;

@Component
public class ShopRepositoryImpl implements ShopRepository {

    //language = sql
    private static final String FIND_ALL = "SELECT shop.name, shop.address, first_name AS owner FROM shop " +
            "JOIN system_user on shop.id = system_user.shop_id;";
    //language = sql
    private static final String FIND_BY_ID = "SELECT shop.name, shop.address, first_name AS owner FROM shop " +
            "JOIN system_user on shop.id = system_user.shop_id WHERE id = ?;";
    //language = sql
    private static final String FIND_BY_NAME = "SELECT shop.address, first_name AS owner FROM shop " +
            "JOIN system_user on shop.id = system_user.shop_id WHERE name = ?;";
    //language = sql
    private static final String ADD_SHOP = "INSERT INTO shop (name, address) VALUES (?, ?);";
    //language = sql
    private static final String EDIT = "UPDATE shop SET name = ?, address = ? WHERE id = ?;";
    //language = sql
    private static final String DELETE_BY_ID = "DELETE FROM shop WHERE id = ?;";


    JdbcTemplate jdbcTemplate;
    @Autowired
    public ShopRepositoryImpl(DriverManagerDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    RowMapper<Shop> rowMapper = (resultSet, i) -> Shop.builder()
            .name(resultSet.getString("name"))
            .address(resultSet.getString("address"))
            .build();


    @Override
    public List<Shop> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
    @Override
    public Shop findById(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, rowMapper, id);
    }
    @Override
    public Shop findByName(String name) {
        return jdbcTemplate.queryForObject(FIND_BY_NAME, rowMapper, name);
    }
    @Override
    public void addShop(Shop shop) {
        jdbcTemplate.update(ADD_SHOP, shop.getName(), shop.getAddress());
    }
    @Override
    public void edit(Shop shop) {
        jdbcTemplate.update(EDIT, shop.getName(), shop.getAddress());
    }
    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
