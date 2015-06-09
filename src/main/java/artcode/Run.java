package artcode;

import artcode.dao.PostDaoImpl;
import artcode.dao.UserDao;
import artcode.dao.UserDaoImpl;
import artcode.dao.UserDaoJpaImpl;
import artcode.service.PostServiceImpl;
import artcode.service.UserService;
import artcode.service.UserServiceImpl;
import artcode.storage.DataHolder;
import artcode.view.UserView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Run {

    public static void main(String[] args) {
        //DataHolder dataHolder = new DataHolder();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        for (String arg : applicationContext.getBeanDefinitionNames()) {
            System.out.println(arg);
        }

        UserView userView = applicationContext.getBean("viewBean", UserView.class);

        userView.start();

    }
}
