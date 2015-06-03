package artcode.service;

import artcode.dao.UserDao;
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
    public User findUser(String name) {
        return null;
    }

    @Override
    public User login(String name, String pass) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
