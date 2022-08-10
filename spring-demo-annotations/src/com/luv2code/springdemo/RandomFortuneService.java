package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = {"Beware of the wolf in sheep's clothing", "Second", "Third"};
	
	// create a random number generator 
	private Random myRandom = new Random();
		
	@Override
	public String getFortune() {
		// pick a random fortunes from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
