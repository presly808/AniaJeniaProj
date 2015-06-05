package artcode.service;

import artcode.dao.UserDao;
import artcode.exception.NoUserFoundException;
import artcode.model.User;

import java.util.List;

/**
 * Created by serhii on 03.06.15.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User register(String name, String pass, int age) {
        //validation data

        // preparing data (preprocess) operation

        // create model object from string data
        User user = new User(name, pass, age);


        return userDao.create(user);
    }

    @Override
    public User findUser(String name) throws NoUserFoundException {
        return userDao.findByName(name);
    }

    @Override
    public User login(String name, String pass) {
        return null;
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
