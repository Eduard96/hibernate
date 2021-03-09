package com.lessons.auto_generated_tables;

import com.lessons.session_factory.SessionFactoryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SomeThing {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryMethod.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Thing thing = new Thing();
        thing.setThingName("Very Interesting thing");

        session.persist(thing);

        session.getTransaction().commit();
        session.close();
    }
}
