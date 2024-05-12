package dao;

import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BookDao {
    @PersistenceContext
    EntityManager entityManager = null; // Inizializzato con null

    default void addBook(Book book) {
        entityManager.persist(book);
    }

    default List<Book> getBooksByAuthor(String author) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class)
                .setParameter("author", author)
                .getResultList();
    }

    // Altre operazioni DAO necessarie per i libri
}
