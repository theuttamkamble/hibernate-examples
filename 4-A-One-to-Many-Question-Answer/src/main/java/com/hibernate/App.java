package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Answer;
import com.hibernate.entity.Question;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
// Create session factory and session
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        
// creating Question and Answer ----1
// creating Question 1
    	Question question1 = new Question();
    	question1.setQuestion("What is Hibernate?");
    	
// creating Question 1's answer1
    	Answer answer1 = new Answer();
    	answer1.setId(1010);
    	answer1.setAnswer("Hibernate is a ORM tool.");
    	answer1.setQuestion(question1);
    	
// creating Question1's answer2
    	Answer answer2 = new Answer();
    	answer2.setId(1011);
    	answer2.setAnswer("Hibernate is a Java Framework.");
    	answer2.setQuestion(question1);
    	
// creating list of answers
    	List<Answer> answers1 = new ArrayList<Answer>();
    	answers1.add(answer1);
    	answers1.add(answer2);
    	
    	question1.setAnswers(answers1);
    	
        
// saving question and answers
        session.save(question1);
        session.save(answer1);
        session.save(answer2);
// -----------------------------------------------------------------------
        
// creating question and Answer ----2
// creating Question 2
        Question question2 = new Question();
        question2.setQuestion("What is ORM?");
        
// creating Question2's Answer1
        Answer answer3 = new Answer();
        answer3.setId(1021);
        answer3.setAnswer("ORM stands for Object Relation Mapping.");
        answer3.setQuestion(question2);
        
// creating Question2's Answer2
        Answer answer4 = new Answer();
        answer4.setId(1022);
        answer4.setAnswer("ORM is a technique for converting data between java objects and relational databases.");
        answer4.setQuestion(question2);
        
// creating Question2's Answer3
        Answer answer5 = new Answer();
        answer5.setId(1023);
        answer5.setAnswer("ORM implements responsibility of mappint the object to relational model and vice versa." );
        answer5.setQuestion(question2);
        
        
// creating list of answer's
        List<Answer> answers2 = new ArrayList<Answer>();
        answers2.add(answer3);
        answers2.add(answer4);
        answers2.add(answer5);
        
        question2.setAnswers(answers2);
        
        
// saving Question and Answers
        session.save(question2);
        session.save(answer3);
        session.save(answer4);
        session.save(answer5);
        
        
        
// transaction committing
        session.getTransaction().commit();
        
        session.close();
        factory.close();
        
        
    }
}
