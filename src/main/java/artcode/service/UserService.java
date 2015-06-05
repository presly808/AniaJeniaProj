package artcode.service;

import artcode.exception.NoUserFoundException;
import artcode.model.User;

import java.util.List;

public interface UserService {

    User register(String name, String pass, int age);

    User findUser(String name) throws NoUserFoundException;

    User login(String name, String pass);

    void delete(long id);

    List<User> findAll();

}
