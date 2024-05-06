package org.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa AuthorDAO oferă metode pentru interacțiunea cu tabela "authors" din baza de date.
 */
public class AuthorDAO {
    private Connection connection;

    /**
     * Constructor pentru clasa AuthorDAO.
     *
     * @param connection Conexiunea la baza de date.
     */
    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adaugă un autor nou în baza de date.
     *
     * @param name   Numele autorului.
     * @param bookId Id-ul cărții la care este asociat autorul.
     */
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

    /**
     * Obține lista de autori pentru o anumită carte din baza de date.
     *
     * @param bookId Id-ul cărții pentru care se doresc autori.
     * @return Lista de autori asociată cărții cu id-ul specificat.
     */
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
