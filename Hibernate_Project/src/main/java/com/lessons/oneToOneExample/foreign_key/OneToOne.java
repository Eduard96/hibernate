package com.lessons.oneToOneExample.foreign_key;

import com.lessons.session_factory.SessionFactoryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * It is OneToOne example with a FOREIGN KEY
 * =
 * @OneToOne(fetch = FetchType.LAZY, optional = false) to avoid N+1 problem when we select Person
 * if we select ARMPassport we have to write Query with JOIN FETCH
 */

public class OneToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryMethod.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

//        Person_2 person2 = new Person_2();
//        person2.setName("Miqael");
//
//        ARMPassport armPassport = new ARMPassport();
//        armPassport.setSerial("Komitas");
////        locations.setPerson(person);
////        session.persist(locations);
//
//        person2.setArm_passport(armPassport);
//        session.persist(person2);
//
//        armPassport.setId(person2.getPersonId());
//        armPassport.setPerson(person2);
//        session.persist(armPassport);
//        armPassport.setSerial("AM666999");
        //session.delete(locations);

//        Locations locations1 = session.get(Locations.class, 1);
//        System.out.println(locations1);
        List<ARMPassport> list = session.createQuery("select a from ARMPassport a join  a.person2", ARMPassport.class).list();
        List<Person_2> list1 = session.createQuery("select a from Person_2 a join  a.arm_passport", Person_2.class).list();
//        List<Person_2> list = session.createQuery("from Person_2 ", Person_2.class).list();
//        List<ARMPassport> list1 = session.createQuery("from ARMPassport ", ARMPassport.class).list();
        list.forEach(System.out::println);
        list1.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
