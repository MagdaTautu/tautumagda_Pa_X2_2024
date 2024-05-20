package org.example;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(
                name = "Book.findByName",
                query = "SELECT b FROM Book b WHERE b.title LIKE :title"
        )
})

public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_id")
        private Long bookId;

        @Column(name = "title")
        private String title;

        @Column(name = "language")
        private String language;

        @Column(name = "publication_date")
        private Date publicationDate;

        @Column(name = "number_of_pages")
        private Integer numberOfPages;

        @ElementCollection
        @Column(name = "authors")
        private List<String> authors;

        public Long getBookId() {
                return bookId;
        }

        public void setBookId(Long bookId) {
                this.bookId = bookId;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getLanguage() {
                return language;
        }

        public void setLanguage(String language) {
                this.language = language;
        }

        public Date getPublicationDate() {
                return publicationDate;
        }

        public void setPublicationDate(Date publicationDate) {
                this.publicationDate = publicationDate;
        }

        public Integer getNumberOfPages() {
                return numberOfPages;
        }

        public void setNumberOfPages(Integer numberOfPages) {
                this.numberOfPages = numberOfPages;
        }

        public List<String> getAuthors() {
                return authors;
        }

        public void setAuthors(List<String> authors) {
                this.authors = authors;
        }
}