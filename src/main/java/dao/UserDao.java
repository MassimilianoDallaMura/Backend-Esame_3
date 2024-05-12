package dao;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public interface UserDao {
    @PersistenceContext
    EntityManager entityManager = null;

    default void addUser(User user) {
        entityManager.persist(user);
    }

    default User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    // Altre operazioni DAO necessarie
}

