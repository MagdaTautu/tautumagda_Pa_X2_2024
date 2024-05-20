package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        Book book = new Book();
        book.setTitle("Sample Book");
        book.setLanguage("English");
        book.setPublicationDate(new Date());
        book.setNumberOfPages(200);
        book.setAuthors(Arrays.asList("Author 1", "Author 2"));
        bookRepository.create(book);

        Book foundBook = bookRepository.findById(1L);
        System.out.println("Found book: " + foundBook.getTitle());

        List<Book> booksByName = bookRepository.findByName("Sample");
        System.out.println("Books found by name pattern:");
        for (Book b : booksByName) {
            System.out.println(b.getTitle());
        }

        EntityManagerFactoryManager.closeEntityManagerFactory();
    }
}
