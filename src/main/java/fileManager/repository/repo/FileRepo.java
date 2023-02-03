package fileManager.repository.repo;

import fileManager.model.File;
import fileManager.repository.entity.FileEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class FileRepo {
    SessionFactory sessionFactory;
    Session session;

    public File fileCreate(File file) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FileEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(file.getName());
        fileEntity.setFilePath(file.getFilePath());
        try {
            session.beginTransaction();
            session.save(fileEntity);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }

        return file;
    }

    public File updateFile(File file) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FileEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            FileEntity fileEntity = session.get(FileEntity.class, file.getId());
            fileEntity.setName(file.getName());
            fileEntity.setFilePath(file.getFilePath());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
        return file;
    }

    public void deleteFile(Integer id) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FileEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            FileEntity fileEntity = session.get(FileEntity.class, id);
            session.delete(fileEntity);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

    public File getByIdFile(Integer id) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FileEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        File file = new File();
        try{
            session.beginTransaction();
            FileEntity fileEntity = session.get(FileEntity.class, id);
            file.setId(fileEntity.getId());
            file.setName(fileEntity.getName());
            file.setFilePath(fileEntity.getFilePath());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
        return file;
    }

    public List<File> getAllFiles() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FileEntity.class).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        List<File> files = new ArrayList<>();
        try {
            session.beginTransaction();
            List<FileEntity> fileEntityList = session.createQuery("from FileEntity").getResultList();
            for(FileEntity fe:fileEntityList) {
                File file = new File();
                file.setId(fe.getId());
                file.setName(fe.getName());
                file.setFilePath(fe.getFilePath());
                files.add(file);
            }
        } finally {
            sessionFactory.close();
            session.close();
        }
        return files;
    }
}
