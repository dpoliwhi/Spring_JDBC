package com.example.springjdbc.mapper;

import com.example.springjdbc.model.Book;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper {
    public Book bookMapper(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        while (resultSet.next()) {
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setDateAdded(resultSet.getDate("date_added"));
        }
        return book;
    }
}
