package com.example.springjdbc.configuration;

import com.example.springjdbc.mapper.BookMapper;
import com.example.springjdbc.mapper.UserMapper;
import org.springframework.context.annotation.*;
import com.example.springjdbc.dao.BookDao;
import com.example.springjdbc.model.User;
import com.example.springjdbc.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.example.springjdbc.DBConstants.*;

@Configuration
@ComponentScan
@Import({UserDao.class, BookDao.class, User.class, BookMapper.class, UserMapper.class})
public class MyConfiguration {
    @Bean
    public Connection connectToData() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    DB_HOST
                            + DB_PORT
                            + DB_DATABASE_NAME,
                              USER, PASS);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
