package homework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {


        BookRepository bookRepository = new BookRepository();
        Book book = new Book("Book2", "English", new Date(), 200);
        bookRepository.create(book);


        /*Book bookFound = bookRepository.findById(1L);
        System.out.println("Book found by id: " + bookFound.getTitle());*/

        List<Book> booksByName = bookRepository.findByName("Book2");
        System.out.println("Books found by name pattern:");
        for (Book b : booksByName) {
            System.out.println(b.getTitle());
        }
        EntityManagerFactoryProvider.closeEntityManagerFactory();
    }
}
