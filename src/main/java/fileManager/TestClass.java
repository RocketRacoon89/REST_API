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
//            FileEntity user = session.get(FileEntity.class, 1);
//            System.out.println(user);
//            session.delete(user);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//            session.close();
//        }

        UserRepo userRepo = new UserRepo();

        System.out.println(userRepo.getByIdUser(7));
    }
}