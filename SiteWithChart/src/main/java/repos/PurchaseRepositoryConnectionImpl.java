package repos;

import lombok.SneakyThrows;
import models.Customer;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class PurchaseRepositoryConnectionImpl implements PurchaseRepository{
    private Connection connection;
    public PurchaseRepositoryConnectionImpl(Connection connection) {
        this.connection = connection;
    }
    //language=SQL
    private static final String SQL_INSERT_INTO_CHART = "INSERT INTO chart(custumer_id, product_id) VALUES(?, ?);";
    @SneakyThrows
    public void save(Product product, Customer customer) {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_CHART);
        preparedStatement.setLong(1, customer.getId());
        preparedStatement.setLong(2, product.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void delete(Object model) {

    }
}
