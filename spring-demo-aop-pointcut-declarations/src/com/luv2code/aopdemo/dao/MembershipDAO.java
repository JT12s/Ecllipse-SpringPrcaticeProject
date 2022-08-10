package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSillyMember() {
	
		System.out.println(getClass() + ": DOING MY WORK: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": goToSleep()");
	}
	
}
