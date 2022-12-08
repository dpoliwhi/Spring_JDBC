package com.example.springjdbc.dao;

import com.example.springjdbc.mapper.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springjdbc.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@AllArgsConstructor
public class BookDao {
    @Autowired
    private Connection connection;
    @Autowired
    private BookMapper bookMapper = new BookMapper();

    public Book findByTitle(String title) {
        String selectTableSQL = "SELECT * FROM library WHERE title = \'" + title + "\'";
        Book book = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            book = bookMapper.bookMapper(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
}
