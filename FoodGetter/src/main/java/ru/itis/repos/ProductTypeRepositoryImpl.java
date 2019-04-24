package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.ProductType;

import java.util.List;

@Component
public class ProductTypeRepositoryImpl implements ProductTypeRepository {

    //language = sql
    private static final String FIND_ALL = "SELECT name FROM product_type;";
    //language = sql
    private static final String FIND_BY_ID = "SELECT name FROM product_type WHERE id = ?;";
    //language = sql
    private static final String RENAME = "UPDATE product_type SET name = ? WHERE id = ?;";
    //language = sql
    private static final String DELETE_BY_ID = "DELETE FROM product_type WHERE id = ?;";


    JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductTypeRepositoryImpl(DriverManagerDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    RowMapper<ProductType> rowMapper = ((resultSet, i) -> ProductType.builder()
        .name(resultSet.getString("name"))
            .build()
    );

    @Override
    public List<ProductType> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
    @Override
    public ProductType findById(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, rowMapper, id);
    }
    @Override
    public void rename(ProductType type) {
        jdbcTemplate.update(RENAME, type.getName(), type.getId());
    }
    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
