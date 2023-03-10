package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
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
        // creating Student object
        Student student = new Student();
        student.setName("Raj");
        
        // creating Course object
        Course course = new Course();
        course.setId(1010);
        course.setCourse("Java Developer");
        course.setFee(40000);
        course.setStudent(student);
        
        student.setCourse(course);
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        // saving student and course
        session.save(student);
        session.save(course);
        
        // commiting transaction
        session.getTransaction().commit();
        
        // close session and factory object
        session.close();
        factory.close();
        
    }
}
