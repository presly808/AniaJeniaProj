package artcode.view;

import artcode.model.User;
import artcode.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private UserService userService;
    private Scanner sc = new Scanner(System.in);

    public UserView(UserService userService) {
        this.userService = userService;
    }

    public void start() {
        while (true) {
            showMainMenu();
            doChoice();
        }
    }

    private void doChoice() {
        int choice = sc.nextInt();

        if (choice == 1) {
            showRegisterMenu();
        } else if (choice == 2) {

        } else if (choice == 3) {

        } else if (choice == 4) {
            showUsersMenu();
        } else if (choice == 5) {
            System.exit(0); //
        } else {
            System.out.println("wrong choice");
        }


    }

    private void showUsersMenu(){
        List<User> userList = userService.findAll();
        System.out.println("USERS LIST");
        for (User user : userList) {
            System.out.println("\t" + user);
        }
    }

    private void showLoginUserMenu(){

    }

    private void showFindUserMenu(){

    }

    private void showRegisterMenu() {
        System.out.println("Input name");
        String name = sc.next();
        System.out.println("Input pass");
        String pass = sc.next();
        System.out.println("Input age");
        int age = sc.nextInt();

        // call service
        User newUser = userService.register(name, pass, age);
        System.out.println("REGISTRATION SUCCESS!");
        System.out.println(newUser);
    }

    private void showMainMenu() {
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.FindUser");
        System.out.println("4.ShowAllUsers");
        System.out.println("5.Exit");
    }


}
