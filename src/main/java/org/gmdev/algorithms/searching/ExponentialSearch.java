package org.gmdev.algorithms.searching;

/**
 * Exponential search algorithm
 * Array need to be sorted
 */
public class ExponentialSearch {
	
	public static void search() {
		int target = 6;
		int[] array = {-30, -9, 1, 4, 6, 8, 30, 72, 453, 756};
	    
	    int indexFound = exponentialSearch(array, target);
	    
	    if (indexFound == -1)
	    	System.out.println("Number: " + target + " not found!");
	    else
	    	System.out.println("Found number: " + target + " at index: " + indexFound);
	}
	
	private static int exponentialSearch(int[] array, int target) {
		int bound = 1;
		
		while (bound < array.length && array[bound] < target)
			bound *= 2;
		
		int left = bound / 2;
		int right = Math.min(bound, array.length - 1);
		return BinarySearch.binarySearchRec(array, left, right, target);
	}

}
