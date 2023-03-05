package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
// creating Configuration object
        Configuration cfg = new Configuration();
        cfg.configure();
        
// creating SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        
// creating Session
        Session session = factory.openSession();

// creating product object.
        Product product1 = new Product(10, "Smart TV", true);
        Product product2 = new Product(12, "Sony Camera", false);
        
// transaction is begins
        session.beginTransaction();
        
// Saving product objects. 
        session.save(product1);
        session.save(product2);
        
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
