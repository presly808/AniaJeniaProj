package artcode.service;

import artcode.model.User;

import java.util.List;

public interface UserService {

    User register(String name, String pass, int age);

    User findUser(String name);

    User login(String name, String pass);

    List<User> findAll();

}
