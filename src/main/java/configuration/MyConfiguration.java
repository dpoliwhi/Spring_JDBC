package configuration;

import org.springframework.context.annotation.*;
import service.Book;
import service.BookDao;
import service.User;
import service.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan
@Import({UserDao.class, BookDao.class, User.class})
public class MyConfiguration {
    @Bean
    public Connection connectToData() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "kosmos");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
