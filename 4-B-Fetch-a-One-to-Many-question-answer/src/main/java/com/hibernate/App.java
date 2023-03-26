package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Question;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        
        Question q1 = session.get(Question.class, 1);
        System.out.println(q1.getId());
        System.out.println(q1.getQuestion());
        System.out.println(q1.getAnswers());
//        System.out.println(q1.getId());
        
    }
}
