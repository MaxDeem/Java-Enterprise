package ru.itis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.models.Owner;

import java.util.List;

@Component
public class OwnerRepositoryImpl implements OwnerRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public OwnerRepositoryImpl(DriverManagerDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //language = sqk
    private static final String FIND_ALL = "SELECT first_name, last_name, address FROM owner;";
    //language = SQL
    private static final String FIND_BY_STATUS = "SELECT first_name, last_name, email, address FROM owner " +
            "WHERE status_id = ?;";
    //language = SQL
    private static final String FIND_BY_ID = "SELECT first_name, last_name, email, address FROM owner " +
            "WHERE id = ?;";
    //language = SQL
    private static final String INSERT_USER = "INSERT INTO owner (first_name, last_name, email, hash_pass, " +
            "address, status_id, psrnsp) VALUES (?, ?, ?, ?, ?, ?, ?);";
    //language = SQL
    private static final String INSERT_SHOP_TO_USER = "UPDATE owner SET shop_id = ? WHERE id = ?;";
    //language = sql
    private static final String UPDATE_OWNER = "UPDATE owner SET first_name = ?, last_name = ?, address = ? WHERE id = ?;";
    //language = SQL
    private static final String DELETE_BY_ID = "DELETE FROM owner WHERE id = ?;";


    RowMapper<Owner> rowMapper = (resultSet, i) -> Owner.builder()
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .email(resultSet.getString("email"))
            .address(resultSet.getString("address"))
            .hashPass(resultSet.getString("hash_pass"))
            .registrationNumber(resultSet.getLong("psrnsp"))
            .build();

    @Override
    public List<Owner> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
    @Override
    public List<Owner> findByStatus(Long id) {
        return jdbcTemplate.query(FIND_BY_STATUS, rowMapper, id);
    }
    @Override
    public Owner findById(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, rowMapper, id);
    }
    @Override
    public void addOwner(Owner owner) {
        jdbcTemplate.update(INSERT_USER, owner.getFirstName(), owner.getLastName(), owner.getEmail(), owner.getHashPass(),
                owner.getAddress(), owner.getStatus().getId(), owner.getRegistrationNumber());
    }
    @Override
    public void addShop(Owner owner) {
        jdbcTemplate.update(INSERT_SHOP_TO_USER, owner.getShop().getId(), owner.getId());
    }

    @Override
    public void updateOwner(Owner owner) {
        jdbcTemplate.update(UPDATE_OWNER, owner.getFirstName(), owner.getLastName(), owner.getAddress(), owner.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
