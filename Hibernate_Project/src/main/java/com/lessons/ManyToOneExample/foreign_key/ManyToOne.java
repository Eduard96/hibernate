package com.lessons.ManyToOneExample.foreign_key;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ManyToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<Man> list = session.createQuery("select a from Man a join fetch a.zodiacSign", Man.class).list();
        //List<Man> list = session.createQuery("from Man ", Man.class).list();
        list.forEach(System.out::println);

        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return  metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
