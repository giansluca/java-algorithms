package org.gmdev.algorithms.sorting;

import org.gmdev.Utils;

/**
 * Selection sort algorithm (iterative and recursive)
 *
 * The idea is to find the minimum value at every pass, and swap it in the sorted array part (the left).
 * Every pass i increase my starting point and i find the new minimum, again swap it until the end (n-1 passes).
 *
 * Standard implementation is Iterative, it can be implemented Recursive as well.
 *
 * Time Complexity: O(n^2)
 * In Place: yes
 * Stable: no
 */
public class SelectionSort {
	
	public static void sortIte() {
		int[] array = {4, 300, 1, 0, 8, 5, 3, 7, -4};
		selectionSortIte(array);
		Utils.printIntArray(array);
	}
	
	public static void sortRec() {
		int[] array = {4, 300, 1, 0, 8, 5, 3, 7, -4, 98};
		selectionSortRec(array, array.length, 0);
		Utils.printIntArray(array);
	}
	
	public static void sortEx() {
		String[] array = {"aa", "paper", "true", "soap", "floppy", "flower", "gigi", "zzz", "aaa"};
		selectionSortEx(array);
		Utils.printStringArray(array);
	}
	
	private static void selectionSortIte(int[] array) {
		int size = array.length;
		
		// passes loop - after size-1 passes we are guaranteed that the array is sorted.
		for (int i = 0; i < size - 1; i++) {
			// store the index of minimum value and loop every pass only over the unsorted part -> ( k=i+1 ).
			int i_min = i;
			for (int k = i + 1; k < size; k++) {
				if (array[k] < array[i_min]) {
					// update the new minimum value.
					i_min = k;
				}
			}
			
			// if i have a new minimum, swap the new min in the sorted array part at correct position.
			if (i_min != i)
				Utils.swapIntArray(array, i_min, i);

		}
	}
	
	private static void selectionSortRec(int[] array, int size, int i) {
		// base case - return when start position and size are same.
		if (i == size)
			return;
		
		// find the minimum in the sub array.
		int i_min = i;
		for	(int k = i + 1; k < size; k++) {
			if	(array[k] < array[i_min]) {
				i_min = k;
			}
		}
		
		// if i have a new minimum, swap the new min in the sorted array part at correct position.
		if (i_min != i)
			Utils.swapIntArray(array, i_min, i);
		
		// recur for all elements except first of current subarray.
		selectionSortRec(array, size, i+1);
	}
	
	private static void selectionSortEx(String[] array) {
		int size = array.length;
		
		// passes loop - after size-1 passes we are guaranteed that the array is sorted.
		for (int i = 0; i < size - 1; i++) {
			// find the min element in the unsorted array, i initially store the first element as min.
	        int i_min = i;
			for (int k = i + 1; k < size; k++) {
				// compare the initial min string with current string.
				if (array[i_min].compareTo(array[k]) > 0) {
					// make array[k] index as new min updating i_min.
					i_min = k;	
				}
			}
			
			// if i have a new minimum, swap the found minimum element with the first element.
			if (i_min != i)
				Utils.swapStringArray(array, i_min, i);
		}	
	}
	
	

}
