package de.tudarmstadt.thesis.jpf.examples;

import java.util.Random;

public class RandomExample {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int a = random.nextInt(2);
		int b = random.nextInt(3);
		int c = a/(b+a-2);
	}
}
