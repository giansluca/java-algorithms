package org.gmdev;

public class Utils {

	public static void printIntArray(int[] array) {
		for (int j : array) System.out.println(j);
	}
	
	public static void printStringArray(String[] array) {
		for (String s : array) System.out.println(s);
	}
	
	public static void swapStringArray(String[] array, int a, int b) {
		String temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void swapCharArray(char[] charArray, int a, int b) {
		char temp = charArray[a] ; 
        charArray[a] = charArray[b]; 
        charArray[b] = temp; 
	}
	
	public static void swapIntArray(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	
}
