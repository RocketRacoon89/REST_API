package fileManager.repository.repo;

import fileManager.model.Event;
import fileManager.model.File;
import fileManager.model.User;
import fileManager.repository.entity.EventEntity;
import fileManager.repository.entity.FileEntity;
import fileManager.repository.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EventRepo {
    SessionFactory sessionFactory;
    Session session;

    public Event createEvent(Event event) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EventEntity.class)
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(FileEntity.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        EventEntity eventEntity = new EventEntity();

        try {
            session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, event.getUser().getId());
            FileEntity fileEntity = session.get(FileEntity.class, event.getFile().getId());
            eventEntity.setUser(userEntity);
            eventEntity.setFile(fileEntity);
            session.save(eventEntity);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return event;
    }

    public Event updateEvent(Event event) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EventEntity.class)
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(FileEntity.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            EventEntity eventEntity = session.get(EventEntity.class, event.getId());
            UserEntity userEntity = session.get(UserEntity.class, event.getUser().getId());
            FileEntity fileEntity = session.get(FileEntity.class, event.getFile().getId());
            eventEntity.setUser(userEntity);
            eventEntity.setFile(fileEntity);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return event;
    }

    public void deleteEvent(Integer id) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EventEntity.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            EventEntity eventEntity = session.get(EventEntity.class, id);
            session.delete(eventEntity);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public Event getByIdEvent(Integer id) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EventEntity.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        Event event = new Event();

        try {
            session.beginTransaction();
            EventEntity eventEntity = session.get(EventEntity.class, id);
            UserRepo userRepo = new UserRepo();
            FileRepo fileRepo = new FileRepo();
            User user = userRepo.getByIdUser(eventEntity.getUser().getId());
            File file = fileRepo.getByIdFile(eventEntity.getFile().getId());
            event.setId(eventEntity.getId());
            event.setUser(user);
            event.setFile(file);
        } finally {
            session.close();
            sessionFactory.close();
        }
        return event;
    }

    public List<Event> getAllEvents() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EventEntity.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        List<Event> events = new ArrayList<>();

        try {
            session.beginTransaction();
            List<EventEntity> eventEntityList = session.createQuery("from EventEntity").getResultList();
            for (EventEntity ee:eventEntityList) {
                Event event = new Event();
                UserRepo userRepo = new UserRepo();
                FileRepo fileRepo = new FileRepo();
                User user = userRepo.getByIdUser(ee.getUser().getId());
                File file = fileRepo.getByIdFile(ee.getFile().getId());
                event.setId(ee.getId());
                event.setUser(user);
                event.setFile(file);
                events.add(event);
            }
        } finally {
            session.close();
            sessionFactory.close();
        }
        return events;
    }

}
