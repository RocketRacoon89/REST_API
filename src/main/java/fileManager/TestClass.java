package fileManager;

import fileManager.model.Event;
import fileManager.model.Operation;
import fileManager.model.User;
import fileManager.repository.entity.EventEntity;
import fileManager.repository.entity.FileEntity;
import fileManager.repository.entity.UserEntity;
import fileManager.repository.repo.UserRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestClass {
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(FileEntity.class)
//                .addAnnotatedClass(UserEntity.class)
//                .addAnnotatedClass(EventEntity.class)
//                .buildSessionFactory();
//
//        Session session = sessionFactory.getCurrentSession();
//
//        try {
//            session.beginTransaction();
//            FileEntity fileEntity = session.get(FileEntity.class, 2);
//            fileEntity.setName("config8");
//            fileEntity.setFilePath("C");
//
//            UserEntity user = session.get(UserEntity.class, 12);
//            user.setName("Vasya");
//
//            EventEntity event = new EventEntity();
//            event.setOperation(Operation.UPDATE.toString());
//            event.setUser(user);
//            event.setFile(fileEntity);
//
//            session.save(event);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//            session.close();
//        }

        UserRepo userRepo = new UserRepo();

        System.out.println(userRepo.getAllUsers());
    }
}
