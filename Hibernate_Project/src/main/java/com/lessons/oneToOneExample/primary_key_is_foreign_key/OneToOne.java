package com.lessons.oneToOneExample.primary_key_is_foreign_key;

import com.lessons.session_factory.SessionFactoryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * It is OneToOne example when PRIMARY KEY  is a FOREIGN KEY
 * This way is better because FetchType.LAZY works both ways
 * =
 * @OneToOne(fetch = FetchType.LAZY, optional = false) to avoid N+1 problem when we select Person
 * if we select Locations we have to write Query with join fetch
 */

public class OneToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryMethod.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        //Person person = session.find(Person.class, 1);
        //System.out.println(person);

//        Person person = new Person();
//        person.setName("qweqweqweqwe");
//
//        session.persist(person);
//
//        Locations locations = new Locations();
//        locations.setLocationName("Bagramyan");
////        locations.setPerson(person);
////        session.persist(locations);
//
//        person.setLocations(locations);
//        session.persist(person);
//
//        locations.setPersonLocationId(person.getPersonId());
//        locations.setPerson(person);
//        session.persist(locations);
//        locations.setLocationName("USA");
        //session.delete(locations);

//        Locations locations1 = session.get(Locations.class, 1);
//        System.out.println(locations1);
        List<Locations> list = session.createQuery("select a from Locations a join fetch a.person", Locations.class).list();
        List<Person> list1 = session.createQuery("select a from Person a join fetch a.locations", Person.class).list();
        //List<Locations> list = session.createQuery("from Locations ", Locations.class).list();
//        List<Person> list = session.createQuery("from Person ", Person.class).list();
        list.forEach(System.out::println);
        list1.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }

}
