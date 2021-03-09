package com.lessons.ManyToOneExample.foreign_key;

import com.lessons.session_factory.SessionFactoryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ManyToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryMethod.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
//        Man man = session.get(Man.class, 10);
//        man.setZodiacSign(session.get(ZodiacSign.class, 2));
//
//        //session.persist(man);
//        //man.setLastname("Ananyan");
//        session.update(man);
//        Man foundMan = session.find(Man.class, 1);
//        System.out.println(foundMan);
        List<Man> manList = session.createQuery("select a from Man a join fetch a.zodiacSign", Man.class).list();
        /**
         * If we select using class OneToMany we should use DISTINCT
         * to avoid duplicates in List
         * That key word we are using in both queries
         * when we are implementing ManyToMany relationships
         */
        List<ZodiacSign> zodiacList = session.createQuery
                ("select distinct amk from ZodiacSign " +
                        "amk join fetch amk.people", ZodiacSign.class).list();
//        List<ZodiacSign> zodiacList = session.createQuery("from ZodiacSign ", ZodiacSign.class).list();
        //List<Man> list = session.createQuery("from Man ", Man.class).list();
//        manList.forEach(System.out::println);
//        System.out.println("=======================================================");
        zodiacList.forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
    }
}