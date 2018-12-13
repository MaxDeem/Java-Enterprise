package repositories;

import lombok.SneakyThrows;
import models.Product;
import models.ProductOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class OrderRepoConnection implements OrderRepo {

    //language=SQL
    private static final String SQL_INSERT_ORDER = "INSERT INTO product_order(address, date, total_price)  VALUES(?, ?, ?);";
    //language=SQL
    private static final String SQL_FIND_ORDERS = "SELECT name, amount, total_price, ordered_to FROM order_info WHERE id = ?;";
    //language=SQL
    private static final String SQL_FIND_ORDER = "SELECT * FROM product_order WHERE id = ?";
    private JdbcTemplate jdbcTemplate;
    public OrderRepoConnection(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    RowMapper<ProductOrder> productOrderRowMapper = ((resultSet, i) -> ProductOrder.builder()
            .id(resultSet.getLong("id"))
            .address(resultSet.getString("address"))
//            .dateTime(resultSet.getTime("date"))
            .totalPrice(resultSet.getDouble("total_price"))
            .build());
    RowMapper<ProductOrder> orderInfoRowMapper = ((resultSet, i) -> ProductOrder.builder()
            .build());
    @Override
    public void save(ProductOrder model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( connection -> {
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ORDER, new String[] {"id"});
                    preparedStatement.setString(1, model.getAddress());
                    preparedStatement.setDate(2, Date.valueOf(model.getDateTime()));
                    preparedStatement.setDouble(3, model.getTotalPrice());
                    return preparedStatement;
                }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<ProductOrder> findOne(Long id) {

        return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ORDER,productOrderRowMapper, id));
    }

    @Override
    public List<ProductOrder> findAll() {
        return null;
    }
}
