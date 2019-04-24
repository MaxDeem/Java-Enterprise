package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DriverManagerDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //language = SQL
    private static final String SELECT_ALL_USERS = "SELECT first_name, last_name, email, address FROM system_user;";
    //language = SQL
    private static final String SELECT_BY_STATUS = "SELECT first_name, last_name, email, address FROM system_user " +
            "WHERE status_id = ?;";
    //language = SQL
    private static final String SELECT_BY_ID = "SELECT first_name, last_name, email, address FROM system_user " +
            "WHERE id = ?;";
    //language = SQL
    private static final String INSERT_USER = "INSERT INTO system_user (first_name, last_name, email, hash_pass, " +
            "address, status_id, psrnsp) VALUES (?, ?, ?, ?, ?, ?, ?);";
    //language = SQL
    private static final String INSERT_SHOP_TO_USER = "UPDATE system_user SET shop_id = ? WHERE id = ?;";
    //language = SQL
    private static final String DELETE_BY_ID = "DELETE FROM system_user WHERE id = ?;";


    RowMapper<User> rowMapper = (resultSet, i) -> User.builder()
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .email(resultSet.getString("email"))
            .address(resultSet.getString("address"))
            .hashPass(resultSet.getString("hash_pass"))
            .registrationNumber(resultSet.getLong("psrnsp"))
            .build();

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SELECT_ALL_USERS, rowMapper);
    }
    @Override
    public List<User> findByStatus(Long id) {
        return jdbcTemplate.query(SELECT_BY_STATUS, rowMapper, id);
    }
    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, rowMapper, id);
    }
    @Override
    public void addUser(User user) {
        jdbcTemplate.update(INSERT_USER, user.getFirstName(), user.getLastName(), user.getEmail(), user.getHashPass(),
                user.getAddress(), user.getStatus().getId(), user.getRegistrationNumber());
    }
    @Override
    public void addShop(User user) {
        jdbcTemplate.update(INSERT_SHOP_TO_USER, user.getShop().getId(), user.getId());
    }
    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
