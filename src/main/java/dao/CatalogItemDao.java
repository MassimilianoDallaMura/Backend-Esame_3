package dao;

import entity.Book;
import entity.CatalogItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CatalogItemDao {
    @PersistenceContext
    EntityManager entityManager = null; // Inizializzato con null

    default void addItem(CatalogItem item) {
        entityManager.persist(item);
    }

    void addItem(Book book);

    default void removeItemByIsbn(String isbn) {
        CatalogItem item = getItemByIsbn(isbn);
        if (item != null) {
            entityManager.remove(item);
        }
    }

    default CatalogItem getItemByIsbn(String isbn) {
        return entityManager.createQuery("SELECT ci FROM CatalogItem ci WHERE ci.isbn = :isbn", CatalogItem.class)
                .setParameter("isbn", isbn)
                .getSingleResult();
    }

    default List<CatalogItem> searchByPublicationYear(int year) {
        return entityManager.createQuery("SELECT ci FROM CatalogItem ci WHERE ci.publicationYear = :year", CatalogItem.class)
                .setParameter("year", year)
                .getResultList();
    }

    default List<CatalogItem> searchByAuthor(String author) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.author = :author", CatalogItem.class)
                .setParameter("author", author)
                .getResultList();
    }

    default List<CatalogItem> searchByTitle(String title) {
        return entityManager.createQuery("SELECT ci FROM CatalogItem ci WHERE ci.title LIKE :title", CatalogItem.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    // Altre operazioni DAO necessarie
}
