package org.gmdev.algorithms.searching;

/**
 * Ternary search algorithm
 * 
 * It is slower than the binary search because there are more comparisons each step
 */
public class TernarySearch {
	
	public static void search() {
		int target = 6;
		int[] array = {-30, -9, 1, 4, 6, 8, 30, 72, 453, 756};
	    
	    int indexFound = ternarySearch(array, target, 0, array.length - 1);
	    
	    if (indexFound == -1)
	    	System.out.println("Number: " + target + " not found!");
	    else
	    	System.out.println("Found number: " + target + " at index: " + indexFound);
		
	}
	
	private static int ternarySearch(int[] array, int target, int left, int right) {
		if(left > right)
			return -1;
			
		int partitionSize = (right - left) / 3;
		int mid1 = left + partitionSize;
		int mid2 = right - partitionSize;
		
		if (array[mid1] == target)
			return mid1;
		
		if (array[mid2] == target)
			return mid2;
		
		
		if (target < array[mid1])
			return ternarySearch(array, target, left, mid1 - 1);
		
		if (target > array[mid2])
			return ternarySearch(array, target, mid2 + 1, right);
		
		return ternarySearch(array, target, mid1 + 1, mid2 - 1);	
	}
 
}
