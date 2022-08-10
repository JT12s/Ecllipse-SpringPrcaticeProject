package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		
		// retrieve bean from spring container
		Coach thecoach = context.getBean("myCoach", Coach.class);
		
		Coach alphacoach = context.getBean("myCoach", Coach.class);	
		
		// check if they are the same
		boolean result = (thecoach == alphacoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + thecoach);
		
		System.out.println("\nMemory location for theCoach: " + alphacoach + "\n");
		
		// close the context
		context.close();
	}

}
