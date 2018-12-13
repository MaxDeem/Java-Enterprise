package app;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.OrderRepoConnection;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Application {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "89090551079VfRc";
    private static final String URL = "jdbc:postgresql://localhost:5432/ProductShop";
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        OrderRepoConnection orderRepoConnection = new OrderRepoConnection(dataSource);
        Optional optional = orderRepoConnection.findOne(1L);
        optional.get().toString();
    }
}
