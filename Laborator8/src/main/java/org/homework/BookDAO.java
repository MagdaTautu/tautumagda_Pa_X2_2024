package org.homework;

import org.homework.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Clasa BookDAO este responsabilă pentru operațiile de acces la date pentru obiectele Book.
 */
public class BookDAO {
    private Connection connection;

    /**
     * Constructor pentru clasa BookDAO.
     *
     * @param connection Conexiunea la baza de date.
     */
    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adaugă o carte în baza de date.
     *
     * @param book Cartea de adăugat.
     */
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
