package com.hibernate;



import com.hibernate.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Tushar");
        user1.setEmail("tushar@gmail.com");
        user1.setGender("Male");
        user1.setPassword("123456");
        user1.setCity("Gurgaon");


        Configuration cfg = new Configuration();
        cfg.configure("com/hibernate/config/hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        // <-------Insert Operation--------->
        try {
            transaction = session.beginTransaction();
            session.persist(user1);
            transaction.commit();
            System.out.println("User added successfully");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("An error occurred");
        }

        //<------Select Operation------->
        try {
            transaction = session.beginTransaction();
            User user2 = session.find(User.class, 2L);
            if (user2 != null) {
            System.out.println("Name - "+ user2.getName());
            System.out.println("City - "+ user2.getCity());
            System.out.println("Email - "+ user2.getEmail());
            System.out.println("Password - "+ user2.getPassword());
            System.out.println("Gender - "+ user2.getGender());
            }
            else {
                System.out.println("User not found !!");
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //<------Update Operation----->
        try {
            transaction = session.beginTransaction();
            User user3 = session.find(User.class, 2L);
            user3.setCity("Bangalore");

            session.merge(user3);
            transaction.commit();
            System.out.println("User details updated successfully");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("User details not updated !!");
        }

        //<------Delete Operation------>
        try {
            transaction = session.beginTransaction();
            User user4 = new User();
            user4.setId(3L);
            session.remove(user4);
            transaction.commit();
            System.out.println("Deletion Successful");

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("Deletion Failed");
        }


    }
}
