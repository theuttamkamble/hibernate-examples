package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // create person
        Person person = new Person();
        person.setName("uttam");
        
        // create address for person
        Address address = new Address();
        address.setPin(112);
        address.setCity("pune");
        
        person.setAddress(address);
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        session.save(person);
        
        session.getTransaction().commit();
        session.close();
    }
}
