package org.gmdev.algorithms.searching;

/**
 * Jump search algorithm
 * 
 * Improvement of linear search but not fast as binary search.
 * Array need to be sorted.
 */
public class JumpSearch {
	
	public static void search() {
		int target = 4;
		int[] array = {-30, -9, 1, 4, 6, 8, 30, 72, 453, 756};
	    
	    int indexFound = jumpSearch(array, target);
	    
	    if (indexFound == -1)
	    	System.out.println("Number: " + target + " not found!");
	    else
	    	System.out.println("Found number: " + target + " at index: " + indexFound);
	}
	
	private static int jumpSearch(int[] array, int target) {
		int blockSize = (int) Math.sqrt(array.length);
		int start = 0;
		int next = blockSize;
		
		while (start < array.length && array[next - 1] < target) {
			start = next;
			
			next += blockSize;
			if (next > array.length)
				next = array.length;
		}
		
		for (int i = start; i < next; i++)
			if (array[i] == target)
				return i;
		
		return -1;
	}

}
