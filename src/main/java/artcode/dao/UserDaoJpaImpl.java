package artcode.dao;

import artcode.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by serhii on 03.06.15.
 */
public class UserDaoJpaImpl implements UserDao {

    private EntityManagerFactory entityManagerFactory;

    public UserDaoJpaImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public User create(User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

        return newUser;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
}
