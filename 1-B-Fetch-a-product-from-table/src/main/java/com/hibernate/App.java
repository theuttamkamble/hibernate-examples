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
              
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Session session = factory.openSession();
        
        Product product1 = session.get(Product.class, 10);
        System.out.println(product1);
        
        Product product2 = session.load(Product.class, 122);
        System.out.println(product2);
        
    }
}
