package com.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
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
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        List<Product> products = session.createQuery("from Product").list();
        System.out.println(products);
        
        
        Query<Product> query = session.createQuery("from Product");
        List<Product> list = query.list();
        
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()) {
        	Product p = itr.next();
        	System.out.println(p);
        }
    }
}
