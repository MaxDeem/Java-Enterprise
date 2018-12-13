package repositories;

import lombok.SneakyThrows;
import lombok.ToString;
import models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
@ToString
public class CustomerRepoConnection implements CustomerRepo {

    //language=sql
    private static final String SQL_INSERT_CUSTOMER = 
                        "INSERT INTO customer(first_name, last_name, email, hash_password) VALUES(?,?,?,?);";
    //language=sql
    private static final String SQL_FIND_CUSTOMER_BY_ID =
            "SELECT first_name, last_name, email, delivered_to, date, product_name FROM customer_info " +
                    "WHERE id = ?";
    //language=SQL
    private static final String SQL_FIND_CUSTOMER_BY_EMAIL =
            "SELECT * FROM customer_info WHERE email = ?";

    JdbcTemplate jdbcTemplate;

    public CustomerRepoConnection(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Customer> customerRowMapper = (resultSet, i) -> Customer.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .email(resultSet.getString("email"))
            .hashPassword(resultSet.getString("hash_password"))
            .build();

    @Override
    public void save(Customer model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_CUSTOMER, new String[] {"id"});
                    preparedStatement.setString(1, model.getFirstName());
                    preparedStatement.setString(2, model.getLastName());
                    preparedStatement.setString(3, model.getEmail());
                    preparedStatement.setString(4, model.getHashPassword());
                    return preparedStatement;
                }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Optional<Customer> findOneByEmail(String email) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_CUSTOMER_BY_EMAIL, customerRowMapper, email));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findOne(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_CUSTOMER_BY_ID, customerRowMapper, id));
    }
}
