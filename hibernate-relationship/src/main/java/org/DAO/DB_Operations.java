package org.DAO;

import org.configurations.HibernateConfigurations;
import org.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DB_Operations {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction t = null;

    public void initSession() {
        if (session == null) {
            session = HibernateConfigurations.getSession();
            sessionFactory = session.getSessionFactory();
        }
    }

    public boolean saveObject(Object o) {
        initSession();
        boolean isSaved = false;
        try {
            t = session.beginTransaction();
            session.persist(o);
            t.commit();
            isSaved = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public boolean deleteObject(Object o) {
        boolean isDeleted = false;
//        if (getUser(((User) o).getUserid()) != null) {
        initSession();
        try {
            t = session.beginTransaction();
            session.remove(o);
            t.commit();
            isDeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        }
        return isDeleted;
    }

    public User getUser(int id) {
        initSession();
        return session.get(User.class, id);
    }
}
