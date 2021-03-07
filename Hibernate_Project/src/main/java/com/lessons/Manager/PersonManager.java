//package com.lessons.Manager;
//
//import com.lessons.oneToOneExample.primary_key_is_foreign_key.Person;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class PersonManager {
//
//    public static void main(String[] args) {
//
//        //jpaExample();
//        sessionExample();
//    }
//
//    private static void jpaExample() {
//        EntityManagerFactory entManFactory = Persistence.createEntityManagerFactory("persistence");
//        EntityManager entityManager = entManFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//        Person person = new Person();
//        person.setName("Tatyana");
//        //person.setPerson_id(1L);
//        System.out.println(person.getPerson_id() + "-------");
//        entityManager.persist(person);
//        System.out.println(person.getPerson_id() + "-------");
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//
//
//
//        entityManager = entManFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.merge(person);
////        Person Eduard = new Person();
////        Eduard.setFirstName("Eduard");
////        Eduard.setLastName("Matveev");
////        Eduard.setPerson_id((long)4);
////        entityManager.close();
////
////        entityManager = entManFactory.createEntityManager();
////        List list = entityManager.createQuery("FROM Person WHERE firstName='Tatyana'").getResultList();
////
////        list.forEach(System.out::println);
////        entityManager.close();
//
//    }
//
//    public static void sessionExample() {
//        SessionFactory sessionFactory = buildSessionFactorys();
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        Person person_1 = new Person();
//
//        person_1.setName("Eduard");
//
//        //session.merge(person_1);
//        person_1.setName("Edo");
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        session.getTransaction().commit();
//
//        session.getTransaction().begin();
//
//
//        Person personForDelete = new Person();
//        personForDelete.setName("Eduard");
//        //personForDelete.setPerson_id((long) 4);
//
//        //session.createQuery()
//
//        session.delete(personForDelete);
//        session.getTransaction().commit();
//        session.close();
////
////
//////        Long id = (Long) session.save(person_1);
//////        System.out.println(id);
////
//////        session.getTransaction().commit();
////        session.close();
//
////        session = sessionFactory.openSession();
////
////        Person person = session.get(Person.class, id);
////        System.out.println(person);
////        session.close();
//
////
////        session = sessionFactory.openSession();
////
////        List<Person> personList = session.createQuery("FROM Person", Person.class).list();
////
////        personList.forEach(System.out::println);
////        session.close();
//    }
//
////    private static SessionFactory buildSessionFactorys() {
////        try {
////            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
////                    .configure("hibernate.cfg.xml").build();
////
////            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
////            return  metadata.getSessionFactoryBuilder().build();
////        } catch (Throwable ex) {
////            System.err.println("Initial SessionFactory creation failed. " + ex);
////            throw new ExceptionInInitializerError(ex);
////        }
////    }
//}
