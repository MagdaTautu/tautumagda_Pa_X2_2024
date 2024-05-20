package homework;

import javax.persistence.*;
import java.util.Date;

/**
 * Clasa Book reprezintă o carte din baza de date.
 */
@Entity
@Table(name = "books")

@NamedQuery(
        name = "Book.findById",
        query = "SELECT b FROM Book b WHERE b.id = :id"
)
@NamedQuery(
        name = "Book.findByName",
        query = "SELECT b FROM Book b WHERE b.title LIKE :title"

)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "language")
    private String language;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "num_Pages")
    private Integer numPages;

    public Book(){}

    /**
     * Constructor pentru clasa Book.
     *
     * @param title           Titlul cărții.
     * @param language        Limba în care este scrisă cartea.
     * @param publicationDate Data publicării cărții.
     * @param numPages        Numărul de pagini al cărții.
     */
    public Book(String title, String language, Date publicationDate, int numPages) {
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numPages = numPages;
    }

    /**
     * Returnează id-ul cărții.
     *
     * @return Id-ul cărții.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setează id-ul cărții.
     *
     * @param id Id-ul cărții.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returnează titlul cărții.
     *
     * @return Titlul cărții.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setează titlul cărții.
     *
     * @param title Titlul cărții.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returnează limba în care este scrisă cartea.
     *
     * @return Limba cărții.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Setează limba în care este scrisă cartea.
     *
     * @param language Limba cărții.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Returnează data publicării cărții.
     *
     * @return Data publicării cărții.
     */
    public Date getPublicationDate() {
        return publicationDate;
    }

    /**
     * Setează data publicării cărții.
     *
     * @param publicationDate Data publicării cărții.
     */
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Returnează numărul de pagini al cărții.
     *
     * @return Numărul de pagini al cărții.
     */
    public int getNumPages() {
        return numPages;
    }

    /**
     * Setează numărul de pagini al cărții.
     *
     * @param numPages Numărul de pagini al cărții.
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    /**
     * Returnează o reprezentare sub formă de string a cărții.
     *
     * @return String reprezentând cărția.
     */
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
