package com.lessons.ManyToManyExample;

import com.lessons.session_factory.SessionFactoryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ManyToMany {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryMethod.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        Reader reader = session.get(Reader.class, 6);
        Reader reader1 = session.find(Reader.class, 1);
        Subscriber subscriber = session.get(Subscriber.class, 2);
        reader.getSubscribers().add(subscriber);


        session.getTransaction().commit();

        List<Reader> readers = session.createQuery("select distinct r from Reader r join fetch r.subscribers", Reader.class).list();

        readers.forEach(System.out::println);
        session.close();

    }
}
