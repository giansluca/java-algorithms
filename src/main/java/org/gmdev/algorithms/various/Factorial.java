package org.gmdev.algorithms.various;

/**
 * Factorial of a number is multiplication of all integers smaller than or equal to number
 */
public class Factorial {
	
	public static void factorialRec() {
		int number = 5;
		int factorial = factorialRec(number);
		System.out.println("Factorial of " + number + " is: " + factorial);
	}
	
	public static void factorialIte() {
		int number = 6;
		int factorial = factorialIte(number);
		System.out.println("Factorial of " + number + " is: " + factorial);
	}
	
	private static int factorialRec(int number) {
		// base case - return if number is equal to 1
		if (number == 1)
			return 1;
		
		return number * factorialRec(number-1);
	}
	
	private static int factorialIte(int number) {
		int factorial = 1;
		
		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		
		return factorial;
	}
	

}
