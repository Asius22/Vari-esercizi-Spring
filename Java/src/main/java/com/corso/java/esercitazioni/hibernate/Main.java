package com.corso.java.esercitazioni.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Genere g = new Genere("Lirico");
        SessionFactory sf = null;
        Session session = null;
        Configuration configuration = new Configuration();
        configuration.configure("META-INF\\hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sf = configuration.buildSessionFactory();
        session = sf.openSession();
        session.persist(g);
        sf.close();
    }
}
