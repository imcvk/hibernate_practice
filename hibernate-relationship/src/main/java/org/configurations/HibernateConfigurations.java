package org.configurations;

import org.entities.Address;
import org.entities.User;
import org.entities.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfigurations {
    public static SessionFactory sessionFactory = null;
    public static Session session = null;
    public static Configuration configuration = null;
    public static ServiceRegistry registry = null;

    public static void initSession() {
        Properties p = new Properties();
        if (sessionFactory == null) {
            p.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
            p.setProperty(Environment.USER, "root");
            p.setProperty(Environment.PASS, "password");
            p.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
            p.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            p.setProperty(Environment.HBM2DDL_AUTO, "update");
            p.setProperty(Environment.AUTOCOMMIT, "true");
        }
        configuration = new Configuration().setProperties(p);
        configuration.addAnnotatedClass(User.class).addAnnotatedClass(Vehicle.class).addAnnotatedClass(Address.class);
        registry = new StandardServiceRegistryBuilder().applySettings(p).build();
        sessionFactory = configuration.buildSessionFactory(registry);
        session = sessionFactory.openSession();
//        return session;
    }
    public static SessionFactory getSessionFactory(){
       if (sessionFactory==null){
           initSession();
       }
       return sessionFactory;
    }

    public static Session getSession() {
        if (session == null) {
            initSession();
        }
        return session;
    }
}
