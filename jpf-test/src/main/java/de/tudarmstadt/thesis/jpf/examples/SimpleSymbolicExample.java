package de.tudarmstadt.thesis.jpf.examples;

public class SimpleSymbolicExample {
	
	public static int test(int param) {
		if(param > 1) {
			return param;
		} else return 0; 
	}
	
	public static void main(String[] args) {
		// Basic SPF example
		test(1);
	}
}
