package com.dell.projects.comicBooksDatasetOptimiser.utilities;

import java.util.Properties;

import com.dell.projects.comicBooksDatasetOptimiser.config.Configurer;
import com.dell.projects.comicBooksDatasetOptimiser.config.PropertiesSetter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionManagement {
    static SessionFactory sessionFactory;
    static ServiceRegistry serviceRegistry;

    public void setupSessionFactory() {


        Configuration configuration = null;
        // configuration.configure("hibernate.cfg.xml");

        Properties properties = new PropertiesSetter().initializeProperties();

        configuration = new Configurer().startConfigurationAndAddClasses(properties);

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public Session getSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    public void flushSession(Session session) {
        session.flush();
    }

    public void close(Session session) {
        try {
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clear(Session session) {
        session.clear();
    }


}

