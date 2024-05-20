package homework;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {
    private final EntityManager entityManager = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();

    public void create(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findByName(String namePattern) {
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findByName", Book.class);
        query.setParameter("title", "%" + namePattern + "%");
        return query.getResultList();
    }
}
