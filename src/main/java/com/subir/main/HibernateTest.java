package com.subir.main;

import com.subir.dto.Address;
import com.subir.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.logging.Logger;

public class HibernateTest {
    public static final Logger logger = Logger.getLogger(HibernateTest.class.getName());
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("First User");
        userDetails.setDescription("This is the first user of our application");
        userDetails.setInstanceDesc("Test User");
        userDetails.setJoinedDate(new Date());
        Address address = new Address();
        Address cityAddress = new Address();
        address.setCity("Bolpur");
        address.setPincode("732104");
        address.setState("West Bengal");
        address.setStreet("Kalikapur");
        userDetails.setHomeAddress(address);
        cityAddress.setStreet("Belur");
        cityAddress.setCity("Kolkata");
        cityAddress.setPincode("731201");
        cityAddress.setState("Karnataka");
        userDetails.setOfficeAddress(cityAddress);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = session.get(UserDetails.class,1);
        logger.info(userDetails.toString());
        session.close();
    }
}
