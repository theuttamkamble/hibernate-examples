package com.hibernate;

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
        
        Student student = new Student();
        
        student = session.get(Student.class, 1);
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getCourse().getId());
        System.out.println(student.getCourse().getCourse());
        System.out.println(student.getCourse().getFee());
    }
}
