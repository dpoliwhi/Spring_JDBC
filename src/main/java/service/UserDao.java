package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    private List<Book> parseBooksString(String line) {
        List<Book> booksList = new ArrayList<>();
        if (line != null) {
            List<String> booksListString = Arrays.stream(line.split(",")).toList();
            booksListString = booksListString.stream().map(String::trim).collect(Collectors.toList());
            booksList = booksListString.stream().map(i -> bookDao.findByTitle(i)).collect(Collectors.toList());
        }
        return booksList;
    }

    private User setUserData(ResultSet rs) throws SQLException {
        User user = new User();
        while (rs.next()) {
            user.setId(Integer.parseInt(rs.getString("id")));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setBirthday(rs.getString("birthday"));
            user.setPhone(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
            String books = rs.getString("books");
            user.setBooks(parseBooksString(books));
        }
        return user;
    }

    public User findById(Integer id) {
        String selectTableSQL = "SELECT * FROM users WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = setUserData(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User findByFirstName(String firstName) {
        String selectTableSQL = "SELECT * FROM users WHERE firstname = " + firstName;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = setUserData(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User findByPhone(String phone) {
        String selectTableSQL = "SELECT * FROM users WHERE phone = \'" + phone + "\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = setUserData(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User findByEmail(String email) {
        String selectTableSQL = "SELECT * FROM users WHERE email = \'" + email + "\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            user = setUserData(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
