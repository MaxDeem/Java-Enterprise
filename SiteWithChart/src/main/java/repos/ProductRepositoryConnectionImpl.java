package repos;

import lombok.SneakyThrows;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryConnectionImpl implements ProductRepository {
    private Connection connection;
    public ProductRepositoryConnectionImpl(Connection connection) {
        this.connection = connection;
    }
    //language=sql
    private static final String SQL_INSERT_INTO_PRODUCT = "INSERT INTO product(name, price) VALUES (?, ?);";
    @Override
    @SneakyThrows
    public void save(Product model) {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_PRODUCT);
        preparedStatement.setString(1, model.getName());
        preparedStatement.setDouble(2, model.getPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Product model) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findOne(Long id) {
        return Optional.empty();
    }
}
