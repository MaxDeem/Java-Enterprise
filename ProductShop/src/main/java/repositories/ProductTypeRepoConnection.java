package repositories;

import lombok.SneakyThrows;
import models.ProductType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ProductTypeRepoConnection implements ProductTypeRepo {

    //language=sql
    private static final String SQL_INSERT_PRODUCT_TYPE = "INSERT INTO product_type(kind) VALUES(?)";

    private JdbcTemplate jdbcTemplate;

    public ProductTypeRepoConnection(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(ProductType model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_PRODUCT_TYPE, new String[] {"id"});
                    preparedStatement.setString(1, model.getKind());
                    return preparedStatement;
                }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductType> findAll() {
        return null;
    }

    @Override
    public Optional<ProductType> findOne(Long id) {
        return Optional.empty();
    }
}
