package dao;

import entity.Loan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LoanDao {
    @PersistenceContext
    EntityManager entityManager = null; // Inizializzato con null

    default void addLoan(Loan loan) {
        entityManager.persist(loan);
    }

    default List<Loan> getLoansByUserId(Long userId) {
        return entityManager.createQuery("SELECT l FROM Loan l WHERE l.user.id = :userId", Loan.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    default List<Loan> getExpiredLoans() {
        return entityManager.createQuery("SELECT l FROM Loan l WHERE l.returnDate IS NULL AND l.dueDate < CURRENT_DATE", Loan.class)
                .getResultList();
    }

    // Altre operazioni DAO necessarie
}

