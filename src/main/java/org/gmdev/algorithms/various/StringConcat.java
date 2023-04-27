package org.gmdev.algorithms.various;

/**
 * Strings array concatenation algorithm
 */
public class StringConcat {
	
	public static void stringConcatIte() {
		String[] array = {"aa", "xx", "paper", "true", "soap", "22", "flower", "gigi", "zzz", "aaa"};
		
		StringBuilder resultString = new StringBuilder();
		stringConcatIte(array, resultString);
		System.out.println(resultString);
	}
	
	public static void stringConcatRec() {
		String[] array = {"aa", "xx", "paper", "true", "soap", "22", "flower", "gigi", "zzz", "ppppp"};
		int size = array.length;
		
		StringBuilder resultString = new StringBuilder();
		stringConcatRec(array, size, resultString, 0);
		System.out.println(resultString);
	}
	
	private static void stringConcatIte(String[] array, StringBuilder resultString) {
		// loop over the array and concat it in a string
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				resultString.append(array[i]);
			} else {
				resultString.append(",").append(array[i]);
			}
		}
	}
	
	private static void stringConcatRec(String[] array, int size, StringBuilder resultString, int index) {
		// base case - if index is equal to size then return
		// (here i'm checking the opposite and put the recursive call inside the 'if' condition)
		if (index < size) {
	    	if (index == 0) {
	    		resultString.append(array[index]);
	        } else {
	        	resultString.append(",").append(array[index]);
	        }
	    	
	    	// recursive call
	    	stringConcatRec(array, size, resultString, index + 1);
	    }    
		
		return;
	}
	
	
}
