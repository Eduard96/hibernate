package com.lessons.oneToOneExample.primary_key_is_foreign_key;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * It is OneToOne example when PRIMARY KEY  is a FOREIGN KEY
 * =
 * @OneToOne(fetch = FetchType.LAZY, optional = false) to avoid N+1 problem when we select Person
 * if we select Locations we have to write Query with join fetch
 */

public class OneToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person person = new Person();
        person.setName("David");

        Locations locations = new Locations();
        locations.setLocationName("Bagramyan");
//        locations.setPerson(person);
//        session.persist(locations);

        person.setLocations(locations);
        session.persist(person);

        locations.setPersonLocationId(person.getPersonId());
        locations.setPerson(person);
        session.persist(locations);
        locations.setLocationName("USA");
        //session.delete(locations);

//        Locations locations1 = session.get(Locations.class, 1);
//        System.out.println(locations1);
        List<Locations> list = session.createQuery("select a from Locations a join fetch a.person", Locations.class).list();
        list.forEach(System.out::println);

        session.getTransaction().commit();
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
