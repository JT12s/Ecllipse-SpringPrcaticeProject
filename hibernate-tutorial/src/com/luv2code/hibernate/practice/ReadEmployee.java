package com.luv2code.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadEmployee {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();		
		
		try {
			
			// Retrieve object from database
			
			// now get a new session and start transaction
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting employee with id: 1");
			
			Employee myEmloyee = session.get(Employee.class, 1);
			
			System.out.println("Get complete: " + myEmloyee);
			
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			// display the students
			System.out.println("\n\nDisplay all Employees");
			displayEmployees(theEmployees);
			
			// retrieve employee by company
			
			// query students: company='Google'
			theEmployees = session.createQuery("from Employee e where e.company='Google'").getResultList();
			
			// display the students
			System.out.println("\n\nEmployees who have last name of Doe");
			displayEmployees(theEmployees);
			
			
			// delete employee by id 
			System.out.println("Deleting studet: " + myEmloyee);
			session.delete(myEmloyee);
			
			System.out.println("Delete employee id=2");
			
			session.createQuery("delete from Employee where id=2").executeUpdate();
			
			// display the students
			theEmployees = session.createQuery("from Employee").getResultList();
			System.out.println("\n\nDisplay all Employees");
			displayEmployees(theEmployees);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee e : theEmployees) {
			System.out.println(e);
		}
	}

}
