package fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.controller.EventController;
import fileManager.controller.FileController;
import fileManager.controller.UserController;
import fileManager.model.Event;
import fileManager.model.Operation;
import fileManager.model.User;
import fileManager.repository.entity.EventEntity;
import fileManager.repository.entity.FileEntity;
import fileManager.repository.entity.UserEntity;
import fileManager.repository.repo.UserRepo;
import fileManager.services.EventService;
import fileManager.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.Principal;
import java.util.*;


public class TestClass {
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(FileEntity.class)
//                .addAnnotatedClass(UserEntity.class)
//                .addAnnotatedClass(EventEntity.class)
//                .buildSessionFactory();
////
//        Session session = sessionFactory.getCurrentSession();
////
//        try {
//            session.beginTransaction();
//            EventEntity eventEntity = session.get(EventEntity.class, 6);
//            session.delete(eventEntity);
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//            session.close();
//        }

//        UserRepo userRepo = new UserRepo();
//
//        System.out.println(userRepo.getAllUsers());
//        List<User> users = new ArrayList<>();
//
//        User user1 = new User();
//        user1.setId(1);
//        user1.setName("Ivan");
//
//        User user2 = new User();
//        user2.setId(2);
//        user2.setName("Oleg");
//
//        User user3 = new User();
//        user3.setId(3);
//        user3.setName("Vasya");
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//
//


//        UserController userController = new UserController();
//
//        List<User> users = new ArrayList<>();
//        User user = userController.getByIdUser(11);
//        users.add(user);
//
//        String user_file_path = "src//main//resources//User.json";
//        File file = new File(user_file_path);
//        Gson gson = new GsonBuilder().create();
//
//        System.out.println(file.exists());
//
//        try (FileWriter writer = new FileWriter(user_file_path)){
//            gson.newBuilder().setPrettyPrinting().create();
//            gson.toJson(users, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        24
//        UserController userController = new UserController();
//        System.out.println(userController.createUser("Test4"));

//        8
//        FileController fileController = new FileController();
//        System.out.println(fileController.createFile("FileTest4", "PathTest4"));

//        8
//        EventController eventController = new EventController();
//        System.out.println(eventController.createEvent(24, 8));


    }
}
