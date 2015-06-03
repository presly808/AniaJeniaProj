package artcode;

import artcode.dao.UserDao;
import artcode.dao.UserDaoImpl;
import artcode.dao.UserDaoJpaImpl;
import artcode.service.UserService;
import artcode.service.UserServiceImpl;
import artcode.storage.DataHolder;
import artcode.view.UserView;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 03.06.15.
 */
public class Run {

    public static void main(String[] args) {
        //DataHolder dataHolder = new DataHolder();
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("my_unit");

        UserDao userDao = new UserDaoJpaImpl(factory);
        UserService userService = new UserServiceImpl(userDao);

        UserView view = new UserView(userService);

        view.start();

    }
}