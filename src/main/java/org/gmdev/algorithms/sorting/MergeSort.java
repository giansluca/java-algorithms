package org.gmdev.algorithms.sorting;

import org.gmdev.Utils;

/**
 * Merge sort algorithm (recursive and iterative)
 * It is a divide and conquer algorithm.
 * The idea is to divide the array in two part (using recursion) until we have a set
 * of one element arrays. Then we merge them back in a sorted array.
 *
 * Standard implementation is Recursive, it can be implemented Iterative as well.
 *
 * Average and Worst case Time Complexity: O(n * log n)
 * In Place: no
 * Stable: Yes
 */
public class MergeSort {
	
	public static void sortRec() {
		int[] array = {4, 2, 1, 6, 8, 1705, 3, 7, -4, 756, -99, 0};
		int size = array.length;
		mergeSortRec(array, 0, size - 1);
		Utils.printIntArray(array);
	}
	
	public static void sortIte() {
		int[] array = {4, 2, 1, 6, 8, 1705, 3, 7, -4, 756, -99, 0};
		mergeSortIte(array);
		Utils.printIntArray(array);
	}
	
	private static void mergeSortRec(int[] array, int left, int right) {
		// base case - if left index is equal to right index, array is size one element and it is ordered.
	    if (left >= right) {
	        return;
	    }
	    
	    // calculate middle index of the array.
	    int mid = (right + left) / 2;
	    
	    // recursive call to divide array in sub array until to each array is size 1.
	    mergeSortRec(array, left, mid);
	    mergeSortRec(array, mid + 1, right);
	    
	    // merge let and right
	    merge(array, left, mid, right);
	}
	
	private static void mergeSortIte(int[] array) {
		int size = array.length;
		int curr_size;      // for current size of subarrays to be merged - curr_size varies from 1 to n/2.
	    int left_start;     // for picking starting index of left subarray to be merged.
	    
	    // Merge subarrays in bottom up manner.  First merge subarrays of
	    // size 1 to create sorted subarrays of size 2, then merge subarrays
	    // of size 2 to create sorted subarrays of size 4, and so on.
	    for (curr_size = 1; curr_size < size; curr_size = 2 * curr_size) {
	    	// Pick starting point of different subarrays of current size
	    	for (left_start = 0; left_start < size - 1; left_start += 2 * curr_size) {
	            // find ending point of left subarray. mid+1 is starting point of right
	    		int mid = min(left_start + curr_size - 1, size - 1);
	    		int right_end = min(left_start + 2 * curr_size - 1, size - 1);
	    		
	    		// merge
	    		merge(array, left_start, mid, right_end);
	        }
	    }
	}
	
	private static void merge(int[] array, int left, int mid, int right) {
	    // calculate left and right arrays size.
	    int left_size = mid - left + 1;
	    int right_size = right - mid;

	    //create temp arrays.
	    int[] left_arr = new int[left_size];
	    int[] right_arr = new int[right_size];
	    
	    // copy data in the two sub arrays.
	    for (int i = 0; i < left_size; i++) {
	        left_arr[i] = array[left + i];
	    }
	    
	    for (int j = 0; j < right_size; j++) {
	        right_arr[j] = array[mid + j + 1];
	    }
	    
	    // Merge the temp arrays back into a sorted array[l..r].
	    int i = 0; // Initial index of first subarray.
	    int j = 0; // Initial index of second subarray.
	    int k = left; // Initial index of merged subarray.
	    
	    while (i < left_size && j < right_size) {
	    	if (left_arr[i] <= right_arr[j]) {
	    		array[k] = left_arr[i];
	    		i++;
	    	} else {
	    		array[k] = right_arr[j];
	    		j++;
	    	}
	    	k++;	
	    }
	    
	    // Copy the remaining elements of left_arr[], if there are any.
	    while (i < left_size) { 
	    	array[k] = left_arr[i]; 
	    	i++; 
	    	k++; 
	    }   
	    
	    // Copy the remaining elements of right_arr[], if there are any.
	    while (j < right_size) { 
	    	array[k] = right_arr[j]; 
	    	j++; 
	    	k++; 
	    }   
	}
	
	private static int min(int x, int y) {
	    return (x < y) ? x : y;
	}
	
	
}
