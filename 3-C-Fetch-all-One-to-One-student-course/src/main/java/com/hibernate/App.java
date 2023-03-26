package com.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

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
        
        List<Student> list = session.createQuery("from Student").list();
        Iterator<Student> itr = list.iterator();
        while(itr.hasNext()) {
        	Student s = itr.next();
        	System.out.print(+s.getId());
        	System.out.print(" - "+s.getName());
        	System.out.print(" - "+s.getCourse().getId());
        	System.out.print(" - "+s.getCourse().getCourse());
        	System.out.println(" - "+s.getCourse().getFee());
        	System.out.println("-------------------------------------------");
        }
        
        session.close();
        factory.close();
    }
}
