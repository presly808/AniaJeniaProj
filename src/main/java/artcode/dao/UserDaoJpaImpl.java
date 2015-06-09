package artcode.dao;

import artcode.exception.NoUserFoundException;
import artcode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoJpaImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public UserDaoJpaImpl() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public UserDaoJpaImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public User create(User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return newUser;
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        //System.out.printf("name %s, age %d", "Kolia", 23);
        try {
            transaction.begin();
            /*Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
            query.setParameter("id", id).executeUpdate();*/
            User user = entityManager.find(User.class,id);
            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    @Override
    public User findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
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

    @Override
    public User findByName(String name) throws NoUserFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //System.out.printf("name %s, age %d", "Kolia", 23);
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name");
        List<User> users = query.setParameter("name", name).setMaxResults(1).getResultList();

        if(users.isEmpty()){
            throw new NoUserFoundException("wrong name");
        }

        return users.get(0);
    }
}
