package com.example.springjdbc.mapper;

import com.example.springjdbc.model.User;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper {
    public User userMapper(ResultSet resultSet) throws SQLException {
        User user = new User();
        while (resultSet.next()) {
            user.setId(Integer.parseInt(resultSet.getString("id")));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setPhone(resultSet.getString("phone"));
            user.setEmail(resultSet.getString("email"));
            user.setBooks(resultSet.getString("books"));
        }
        return user;
    }
}
