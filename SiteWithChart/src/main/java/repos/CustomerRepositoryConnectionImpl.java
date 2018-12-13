package repos;

import lombok.SneakyThrows;
import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryConnectionImpl implements CustomerRepository {
    private Connection connection;
    public CustomerRepositoryConnectionImpl(Connection connection) {
        this.connection = connection;
    }

    //language=SQL
    private static final String SQL_INSERT_INTO_CUSTOMER = "INSERT INTO customer(firt_name, last_name, email, hash_password) VALUES (?,?,?,?);";
    @Override
    @SneakyThrows
    public void save(Customer model) {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_CUSTOMER);
        preparedStatement.setString(1, model.getFirst_name());
        preparedStatement.setString(2, model.getLast_name());
        preparedStatement.setString(3, model.getEmail());
        preparedStatement.setString(4, model.getHash_password());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Customer model) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findOne(Long id) {
        return Optional.empty();
    }
}
