package com.subir.main;

import com.subir.dto.Address;
import com.subir.dto.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.logging.Logger;

public class UserTest {
    public static final Logger logger = Logger.getLogger(HibernateTest.class.getName());
    public static void main(String[] args) {
        Users users = new Users();
        users.setUserName("First User");
        users.setDescription("This is the first user of our application");
        users.setInstanceDesc("Test User");
        users.setJoinedDate(new Date());

        Address address = new Address();
        address.setCity("Bolpur");
        address.setPincode("732104");
        address.setState("West Bengal");
        address.setStreet("Kalikapur");
        users.getListOfAddress().add(address);

        Address cityAddress = new Address();
        cityAddress.setStreet("Egipura");
        cityAddress.setCity("Bangalore");
        cityAddress.setPincode("500020");
        cityAddress.setState("Karnataka");
        users.getListOfAddress().add(cityAddress);
        logger.info(users.toString());

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(users);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        users = session.get(Users.class,1);
        logger.info(users.toString());
        session.close();
    }
}
