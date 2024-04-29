package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAuthor(String name, int bookId) {
        String query = "INSERT INTO authors (name, book_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAuthorsForBook(int bookId) {
        List<String> authors = new ArrayList<>();
        String query = "SELECT name FROM authors WHERE book_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                authors.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
