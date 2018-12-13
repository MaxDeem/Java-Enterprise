package repositories;

import lombok.SneakyThrows;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ProductRepoConnection implements ProductRepo {

    Connection connection;

    public ProductRepoConnection(Connection connection) {
        this.connection = connection;
    }
    //language=sql
    private static final String SQL_INSERT_PRODUCT = "INSERT INTO product(name, type, price) VALUES(?,?,?)";
    @SneakyThrows
    @Override
    public void save(Product model) {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PRODUCT);
        preparedStatement.setString(1, model.getName());
        preparedStatement.setLong(2, model.getType().getId());
        preparedStatement.setDouble(3, model.getPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return Optional.empty();
    }
}
