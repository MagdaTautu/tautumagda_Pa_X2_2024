package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        connection = Database.getConnection();
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, language, publication_date, num_pages) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getLanguage());
            statement.setDate(3, new java.sql.Date(book.getPublicationDate().getTime()));
            statement.setInt(4, book.getNumPages());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
