package fileManager.repository.repo;

import fileManager.model.Event;
import fileManager.model.User;
import fileManager.repository.entity.EventEntity;
import fileManager.repository.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    SessionFactory sessionFactory;
    Session session;

    public User createUser(User user) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        try {
            session.beginTransaction();
            session.save(userEntity);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }

        return user;
    }

    public User updateUser(User user) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, user.getId());
            userEntity.setName(user.getName());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
        return user;
    }

    public void deleteUser(Integer id) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, id);
            session.delete(userEntity);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

    public User getByIdUser(Integer id) {
        User user = new User();
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, id);
            user.setId(userEntity.getId());
            user.setName(userEntity.getName());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
        return user;
    }

//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class).buildSessionFactory();
//        session = sessionFactory.getCurrentSession();
//
//        try {
//            session.beginTransaction();
//            List<UserEntity> userEntityList = session.createQuery("from users").getResultList();
//
//            for(UserEntity ue : userEntityList) {
//                User user = new User();
//                user.setId(ue.getId());
//                user.setName(ue.getName());
//                List<Event> events = new ArrayList<>();
//                for(EventEntity ee : ue.getEventEntities()) {
//                    Event event = new Event();
//                    event.setId(ee.getId());
//                    event.setUser(user);
//                    event.setFile();
//                    event.setOperation();
//                    events.add(event);
//                }
//
//            }
//        }
//    }
}
