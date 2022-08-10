package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		String[] fortune_array = {"Today is your lucky day!", "Bad fortune today, be careful!", "Nothing good and nothing bad..."};
		Random rand = new Random();
		int index = rand.nextInt(3);
		return fortune_array[index];
	}

}
