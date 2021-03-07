package com.lessons.oneToOneExample.foreign_key;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * It is OneToOne example with a FOREIGN KEY
 * =
 * @OneToOne(fetch = FetchType.LAZY, optional = false) to avoid N+1 problem when we select Person
 * if we select ARMPassport we have to write Query with JOIN FETCH
 */

public class OneToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person_2 person2 = new Person_2();
        person2.setName("Miqael");

        ARMPassport armPassport = new ARMPassport();
        armPassport.setSerial("Komitas");
//        locations.setPerson(person);
//        session.persist(locations);

        person2.setArm_passport(armPassport);
        session.persist(person2);

        armPassport.setId(person2.getPersonId());
        armPassport.setPerson(person2);
        session.persist(armPassport);
        armPassport.setSerial("AM666999");
        //session.delete(locations);

//        Locations locations1 = session.get(Locations.class, 1);
//        System.out.println(locations1);
        List<ARMPassport> list = session.createQuery("select a from ARMPassport a join fetch a.person2", ARMPassport.class).list();
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
