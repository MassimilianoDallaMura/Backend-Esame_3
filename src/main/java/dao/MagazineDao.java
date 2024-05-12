package dao;

import entity.Magazine;
import enums.Periodicity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MagazineDao {
    @PersistenceContext
    EntityManager entityManager = null; // Inizializzato con null

    default void addMagazine(Magazine magazine) {
        entityManager.persist(magazine);
    }

    default List<Magazine> getMagazinesByPeriodicity(Periodicity periodicity) {
        return entityManager.createQuery("SELECT m FROM Magazine m WHERE m.periodicity = :periodicity", Magazine.class)
                .setParameter("periodicity", periodicity)
                .getResultList();
    }

    // Altre operazioni DAO necessarie per le riviste
}
