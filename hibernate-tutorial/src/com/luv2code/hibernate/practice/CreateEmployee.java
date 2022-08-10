package com.luv2code.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateEmployee {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();		
		
		try {
			// create a employee object
			System.out.println("Creating new employee object ...");
			Employee tempEmployee1 = new Employee("Paul", "Wall", "Google");
			Employee tempEmployee2 = new Employee("Megan", "Alice", "Amazon");
			Employee tempEmployee3 = new Employee("Josh", "Howard", "Apple");
			Employee tempEmployee4 = new Employee("Derrick", "Jason", "Meta");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object 
			System.out.println("Saving the employee ...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
