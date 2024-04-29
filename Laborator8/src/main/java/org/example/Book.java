package org.example;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String language;
    private Date publicationDate;
    private int numPages;

    public Book(String title, String language, Date publicationDate, int numPages) {
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numPages = numPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", publicationDate=" + publicationDate +
                ", numPages=" + numPages +
                '}';
    }
}
