package com.example.springjdbc.dao;

import com.example.springjdbc.mapper.UserMapper;
import com.example.springjdbc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springjdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDao {
    @Autowired
    private Connection connection;
    @Autowired
    private BookDao bookDao;
    @Autowired
    User user;
    @Autowired
    private UserMapper userMapper = new UserMapper();

    public User getUserById(Integer id) {
        String selectTableSQL = "SELECT * FROM users WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = userMapper.userMapper(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User getUserByFirstName(String firstName) {
        String selectTableSQL = "SELECT * FROM users WHERE firstname = " + firstName;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = userMapper.userMapper(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    private User findByPhone(String phone) {
        String selectTableSQL = "SELECT * FROM users WHERE phone = \'" + phone + "\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = userMapper.userMapper(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    private User findByEmail(String email) {
        String selectTableSQL = "SELECT * FROM users WHERE email = \'" + email + "\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = userMapper.userMapper(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    private List<Book> getBooksOfUser(User user) {
        List<Book> books = new ArrayList<>();
        String booksString = user.getBooks();
        List<String> booksListString = Arrays.stream(booksString.split(",")).toList();
        booksListString = booksListString.stream().map(String::trim).collect(Collectors.toList());
        books = booksListString.stream().map(i -> bookDao.findByTitle(i)).collect(Collectors.toList());
        return books;
    }

    public List<Book> getBooksOfUserByPhone(String phone) {
        user = findByPhone(phone);
        return getBooksOfUser(user);
    }

    public List<Book> getBooksOfUserByEmail(String email) {
        user = findByEmail(email);
        return getBooksOfUser(user);
    }

    public void createUser(User user) {
        String insertQuery =
                "INSERT INTO users (firstname, lastname, birthday, phone, email, books) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setDate(3, (Date) user.getBirthday());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getBooks());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
