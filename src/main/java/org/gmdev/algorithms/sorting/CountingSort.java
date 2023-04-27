package org.gmdev.algorithms.sorting;

import org.gmdev.Utils;

/**
 * Counting sort (only positive integers)
 * sort an array of positive integer by counting the occurrences of each number 
 * and storing it in a separate extra array. Each number represent an index of the counting array
 * It is fast but it requires extra memory and to know the value of the max element of the array.
 * 
 * Time Complexity: O(n)
 */
public class CountingSort {
	
	public static void sort() {
		int[] array = {4, 2, 1, 6, 8, 5, 3, 1, 12};
		countingSort(array, 12);
		Utils.printIntArray(array);
	}
	
	private static void countingSort(int[] array, int max) {
		int[] counts = new int[max + 1];
		
		for (var item : array) 
			counts[item]++;
		
		var k = 0;
		for (var i = 0; i < counts.length; i++) {
			for (var j = 0; j < counts[i]; j++) {
				array[k++] = i;
			}
		}
	}
	
	

}
