package com.luv2code.springdemo;

public class BasketballCoach implements Coach{
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for the dependency injection
	public BasketballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "200 free throw.";
	}

	@Override
	public String getDailyEnergy() {
		return "You need 3001 calories.";
	}

	@Override
	public String getDailyFortune() {
		
		// use my fortuneService to give fortune
		
		return fortuneService.getFortune();
	}

}
