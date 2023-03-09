package com.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        List<Person> list = session.createQuery("from Person").list();
        
        Iterator<Person> itr = list.iterator();
        while(itr.hasNext()) {
        	Person p = new Person();
        	p = itr.next();
        	System.out.println(p);
        }
        
        session.close();
        factory.close();
    }
}
