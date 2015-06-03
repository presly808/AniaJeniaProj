package artcode.dao;

import artcode.model.User;

import java.util.List;

// CRUD
public interface UserDao {

    User create(User newUser);
    void delete(long id);
    User findById(long id);
    User update(User user);
    List<User> findAll();

}
