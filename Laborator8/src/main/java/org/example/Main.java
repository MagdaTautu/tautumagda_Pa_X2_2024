package org.example;

import java.util.Date;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            Database mydatabase = new Database();
            mydatabase.createConnection();

            Book book1 = new Book("Book 1", "English", new Date(), 200);
            Book book2 = new Book("Book 2", "French", new Date(), 250);
            Book book3 = new Book("Book 3", "Spanish", new Date(), 180);
            BookDAO bookDAO = new BookDAO();
            bookDAO.addBook(book1);
            bookDAO.addBook(book2);
            bookDAO.addBook(book3);

            var authors = new AuthorDAO(mydatabase.getConnection());
            authors.addAuthor("Author 1", book1.getId());
            authors.addAuthor("Author 3", book2.getId());
            authors.addAuthor("Author 6", book3.getId());

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
