package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.DeliveryMan;

import java.util.List;
@Component
public class DeliveryManRepositoryImpl implements DeliveryManRepository {

    //language = sql
    public static final String FIND_ALL = "SELECT first_name, last_name, address FROM deliveryman;";
    //language = sql
    public static final String FIND_BY_STATUS = "SELECT first_name, last_name, address FROM deliveryman WHERE status_id = ?;";
    //language = sql
    public static final String FIND_BY_ID = "SELECT first_name, last_name, email, address FROM deliveryman WHERE id = ?;";
    //language = sql
    public static final String ADD_DELIVERER = "INSERT INTO deliveryman (first_name, last_name, email, address, hash_pass, status_id) " +
            "VALUES (?, ?. ?, ?, ?, ?);";
    //language = sql
    public static final String UPDATE_BUSY = "UPDATE deliveryman SET isBusy = true WHERE id = ?;";
    //language = sql
    public static final String UPDATE_FREE = "UPDATE deliveryman SET isBusy = false WHERE id = ?";
    //language = sql
    public static final String UPDATE_DELIVERER = "UPDATE deliveryman SET first_name = ?, last_name = ?, address = ? " +
            "WHERE id = ?;";
    //language = sql
    public static final String DELETE_DELIVERER = "DELETE FROM deliveryman WHERE id = ?;";
    JdbcTemplate jdbcTemplate;
    @Autowired
    public DeliveryManRepositoryImpl(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    RowMapper<DeliveryMan> rowMapper = ((resultSet, i) -> DeliveryMan.builder()
        .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .email(resultSet.getString("email"))
            .address(resultSet.getString("address"))
            .hashPass(resultSet.getString("hash_pass"))
            .build()
    );

    @Override
    public List<DeliveryMan> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
    @Override
    public List<DeliveryMan> findByStatus(Long id) {
        return jdbcTemplate.query(FIND_BY_STATUS, rowMapper, id);
    }
    @Override
    public DeliveryMan findById(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, rowMapper, id);
    }
    @Override
    public void addDeliverer(DeliveryMan user) {
        jdbcTemplate.update(ADD_DELIVERER, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress(),
                user.getHashPass(), user.getStatus().getId());
    }

    @Override
    public void setBusy(DeliveryMan deliveryMan) {
        jdbcTemplate.update(UPDATE_BUSY, deliveryMan.getId());
    }

    @Override
    public void setFree(DeliveryMan deliveryMan) {
        jdbcTemplate.update(UPDATE_FREE, deliveryMan.getId());
    }

    @Override
    public void updateDeliverer(DeliveryMan user) {
        jdbcTemplate.update(UPDATE_DELIVERER, user.getFirstName(), user.getLastName(), user.getAddress());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_DELIVERER, id);
    }
}
