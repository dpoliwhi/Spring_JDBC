package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Component
public class UserDao {
    private final Connection connection;

    public UserDao(@Autowired Connection connection) { // (1)
        this.connection = connection;
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
        }
        return user;
    }

    public User findById(Integer id) {
        String selectTableSQL = "SELECT * FROM users WHERE id = " + id;
        User user = new User();
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
        User user = new User();
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
