package service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@AllArgsConstructor
public class BookDao {
    @Autowired
    private Connection connection;

    public Book findByTitle(String title) {
        String selectTableSQL = "SELECT * FROM library WHERE title = \'" + title + "\'";
        Book book = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                book = new Book(rs.getString("title"), rs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
}
