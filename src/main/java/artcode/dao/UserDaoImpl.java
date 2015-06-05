package artcode.dao;

import artcode.exception.NoUserFoundException;
import artcode.model.User;
import artcode.storage.DataHolder;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 03.06.15.
 */
public class UserDaoImpl implements UserDao {

    private DataHolder dataHolder;

    public UserDaoImpl(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Override
    public User create(User newUser) {
        return dataHolder.add(newUser);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new LinkedList<>();


        Collection<User> values = dataHolder.getUserMap().values();
        for (User user : values) {
            users.add(user);
        }

        // see Collections class

        return users;
    }

    @Override
    public User findByName(String name) throws NoUserFoundException {
        return null;
    }
}
