package artcode.view;

import artcode.exception.NoUserFoundException;
import artcode.model.Post;
import artcode.model.User;
import artcode.service.PostService;
import artcode.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private PostService postService;
    private UserService userService;
    private Scanner sc = new Scanner(System.in);

    public UserView(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

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
            showFindUserMenu();
        } else if (choice == 4) {
            showUsersMenu();
        } else if (choice == 5) {
            System.exit(0); //
        } else if(choice == 6){
            showUserPostsMenu();
        } else if(choice == 7){
            showDeleteUserMenu();
        }else {
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
        System.out.println("input name");
        String name = sc.next();
        try {
            User user = userService.findUser(name);
            System.out.println(user);
        } catch (NoUserFoundException e) {
            System.err.println(e.getMessage());
        }

    }

    public void showUserPostsMenu(){
        System.out.println("Input user id");
        long id = sc.nextInt();
        List<Post> list = postService.getUserPosts(id);
        for (Post post : list) {
            System.out.println("\t" + post);
        }
    }

    public void showDeleteUserMenu(){
        System.out.println("Input user id");
        long id = sc.nextInt();
        userService.delete(id);
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
        System.out.println("6.User posts");
        System.out.println("7.delete user");
    }


}
