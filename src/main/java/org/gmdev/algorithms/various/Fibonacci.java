package org.gmdev.algorithms.various;

/**
 * Fibonaci number is the sum of two previous fibonacci numbers
 */
public class Fibonacci {
	
	public static void fibonacciRec() {
		int number = 9;
		int fibo = fibonacciRec(number);
		System.out.println("The " + number + "th Fibonacci number is: " + fibo);
	}
	
	public static void fibonacciIte() {
		int number = 8;
		int fibo = fibonacciIte(number);
		System.out.println("The " + number + "th Fibonacci number is: " + fibo);
	}
	
	private static int fibonacciRec(int number) {
		if (number <= 1)
			return number;
		
		return fibonacciRec(number-1) + fibonacciRec(number-2);
	}
	
	private static int fibonacciIte(int number) {
		int a = 0;
		int b = 1;
		int c, i;
		
		if (number == 0) {
			return a;
		}
		
		for (i = 2; i <= number; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return b;
	}

}
