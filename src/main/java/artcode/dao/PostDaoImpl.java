package artcode.dao;

import artcode.model.Post;
import artcode.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by serhii on 05.06.15.
 */
public class PostDaoImpl implements PostDao {

    private EntityManagerFactory factory;

    public PostDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Post> getUserPosts(long id) {
        EntityManager manager = factory.createEntityManager();
        User found = manager.find(User.class,id);
        return found.getPosts();
    }

    public PostDaoImpl() {
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }
}
