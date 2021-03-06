package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.DeliveryMan;
import ru.itis.models.Order;
import ru.itis.models.User;

import java.util.List;
@Component
public class OrderRepositoryImpl implements OrderRepository {

    //language = sql
    private static final String FIND_ALL = "SELECT shop.name AS ordered_from, from_address, first_name AS ordered_by, " +
            "to_address, price, paid AS status FROM shopping_order " +
            "JOIN shop on shop.id = shopping_order.id " +
            "JOIN system_user su on shopping_order.id = su.order_id;";
    //language = sql
    private static final String FIND_BY_USER = "SELECT shop.name AS ordered_from, from_address, " +
            "to_address, price, paid AS status FROM shopping_order " +
            "JOIN shop on shop.id = shopping_order.id " +
            "JOIN system_user su on shopping_order.id = su.order_id WHERE su.id = ?;";
    //language = sql
    private static final String FIND_BY_ID = "SELECT shop.name AS ordered_from, from_address, first_name AS ordered_by, " +
            "to_address, price, paid AS status FROM shopping_order " +
            "JOIN shop on shop.id = shopping_order.id " +
            "JOIN system_user su on shopping_order.id = su.order_id WHERE shopping_order.id = ?;";
    //language = sql
    private static final String FIND_ORDERED = "SELECT shop.name AS ordered_from, from_address, first_name AS ordered_by, " +
            "to_address, price, paid AS status FROM shopping_order " +
            "JOIN shop on shop.id = shopping_order.id " +
            "JOIN system_user su on shopping_order.id = su.order_id WHERE deliverer_id = NULL;";
    //language = sql
    private static final String ADD_ORDER = "INSERT INTO shopping_order (from_address, to_address, price, user_id) VALUES (?, ?, ?, ?);";
    //language = sql
    private static final String UPDATE_DELIVERER = "UPDATE shopping_order SET deliverer_id = ? WHERE id = ?";
    //language = sql
    private static final String UPDATE_ORDER = "UPDATE shopping_order SET to_address = ? WHERE id = ?;";
    //language = sql
    private static final String UPDATE_STATUS = "UPDATE shopping_order SET paid = TRUE WHERE id = ?;";
    //language = sql
    private static final String DELETE_BY_USER = "DELETE FROM shopping_order WHERE user_id = ?";
    //language = sql
    private static final String DELETE_BY_ID = "DELETE FROM shopping_order WHERE id = ?;";
    JdbcTemplate jdbcTemplate;
    @Autowired
    public OrderRepositoryImpl(DriverManagerDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    RowMapper<Order> rowMapper = (resultSet, i) -> Order.builder()
            .from(resultSet.getString("from_address"))
            .to(resultSet.getString("to_address"))
            .price(resultSet.getDouble("price"))
            .paid(resultSet.getBoolean("paid"))
            .build();


    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
    @Override
    public List<Order> findByUser(User user) {
        return jdbcTemplate.query(FIND_BY_USER, rowMapper, user.getId());
    }
    @Override
    public Order findById(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, rowMapper, id);
    }
    @Override
    public List<Order> findOrdered() {
        return jdbcTemplate.query(FIND_ORDERED, rowMapper);
    }
    @Override
    public void addOrder(Order order, User user) {
        jdbcTemplate.update(ADD_ORDER, order.getFrom(), order.getTo(), order.getPrice(), user.getId());
    }
    @Override
    public void updateDeliverer(Order order, DeliveryMan deliveryMan) {
        jdbcTemplate.update(UPDATE_DELIVERER, deliveryMan.getId(), order.getId());
    }
    @Override
    public void updateOrder(Order order) {
        jdbcTemplate.update(UPDATE_ORDER, order.getTo(), order.getId());
    }
    @Override
    public void updateOrderStatus(Order order) {
        jdbcTemplate.update(UPDATE_STATUS, order.getId());
    }
    @Override
    public void deleteByUser(User user) {
        jdbcTemplate.update(DELETE_BY_USER, user.getId());
    }
    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
