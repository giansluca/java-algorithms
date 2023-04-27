package org.gmdev.algorithms.sorting;

import org.gmdev.Utils;

/**
 * Bubble sort algorithm (iterative and recursive)
 *
 * The idea is to move in every pass the max element to the end of the array,
 * building in that way a sorted part (right) and unsorted part (left).
 * For each pass i will loop only over the unsorted part, and a flag to check if there have been a swap,
 * will tell me if the array is already sorted.
 * 
 * Standard implementation is Iterative, it can be implemented Recursive as well.
 *
 * Worst and Average Case Time Complexity: O(n^2)
 * Best case Time Complexity: O(n)
 * In Place: yes
 * Stable: yes
 */
public class BubbleSort {
	
	public static void sortIte() {
		int[] array = {4, 2, 1, 6, 8, 5, 3, 7, -4};
		bubbleSortIte(array);
		Utils.printIntArray(array);
	}
	
	public static void sortRec() {
		int[] array = {4, 2, 1, 6, 8, 5, 3, 7, -4, 756, -9, 0};
		bubbleSortRec(array, array.length);
		Utils.printIntArray(array);
	}
	
	public static void sortEx() {
		String[] array = {"aa", "xx", "paper", "true", "soap", "22", "flower", "gigi", "zzz", "aaa"};
		bubbleSortEx(array);
		Utils.printStringArray(array);
	}
	
	private static void bubbleSortIte(int[] array) {
		int size = array.length;
		
		// passes loop - after size-1 passes we are guaranteed that the array is sorted.
		for (int i = 0; i < size - 1; i++) {
			boolean flag = false;
			
			// loop every pass only over the unsorted part -> ( i < size-k-1 ).
			for (int k=0; k < size - i - 1; k++) {
				if (array[k] > array[k + 1]) {
					// if next element is smaller then swap.
					Utils.swapIntArray(array, k, k + 1);
					flag = true;
				}
			}
			
			// improvement: if there have been no swaps the array is already sorted, so i exit.
			if (!flag) {
				break;
			}
		}
	}
	
	private static void bubbleSortRec(int[] array, int size) {
		// base case - return when the size is equal to 1, the array is sorted.
		if (size == 1)
			return;
		
		boolean flag = false;
		// one pass of normal bubble sort, to fix the last element (max value) of current subarray.
		for (int i = 0; i < size - 1; i++) {
			if (array[i] > array[i + 1]) {
				// if next element is smaller then swap.
				Utils.swapIntArray(array, i, i + 1);
				flag = true;
			}
		}
		
		// improvement: if there have been no swaps the array is already sorted, so i return.
	    if (!flag) {
	        return;
	    }
	    
	    // recur for all elements except last of current subarray.
	    bubbleSortRec(array, size-1);
	}
	
	private static void bubbleSortEx(String[] array) {
		int size = array.length;
		
		// after size-1 passes we are guaranteed that the array is sorted.
		for (int i = 0; i < size; i++) {
			boolean flag = false;
			
			// loop every pass only over the unsorted part -> ( i < size-k-1 ).
			for (int k = 0; k < size - i - 1; k++) {
				// compare the actual string with the next, if the left string bigger then swap.
				if (array[k].compareTo(array[k + 1]) > 0) {
					Utils.swapStringArray(array, k, k + 1);
					flag = true;
				}
			}
			
			// if there have been no swaps the array is already sorted, so i exit.
			if (!flag) {
				break;
			}	
		}	
	}
	
	

}
