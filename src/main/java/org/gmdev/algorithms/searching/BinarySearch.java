package org.gmdev.algorithms.searching;

/**
 * Binary search algorithm (iterative and recursive)
 * 
 * For binary search the array must be sorted
 * it is a search that reduce the the search space into half respect linear search "O(n)" only
 * because the array is sorted.
 * The idea is to find the middle index of the array and check if the number we are searching is
 * equal or bigger or smaller of it. If it is bigger we continue with the same method in the right
 * part of the array until we will find it. If it is smaller we do the same thing but in the left part
 * of the array.
 *
 * Implementation can be Iterative o Recursive
 *
 * Worst and Average case Time complexity: O(log n)
 */
public class BinarySearch {
	
	public static void searchIte() {
		int x = 453;
		int[] array = {-30, -9, 1, 4, 6, 8, 30, 72, 453, 756};
	    
	    int indexFound = binarySeachIte(array, x);
	    
	    if (indexFound == -1)
	    	System.out.println("Number: " + x + " not found!");
	    else
	    	System.out.println("Found number: " + x + " at index: " + indexFound);
	}
	
	public static void searchRec() {
		int x = 72;
		int[] array = {-30, -9, 1, 4, 6, 8, 30, 72, 453, 756};
	    int size = array.length;
	    
	    int indexFound = binarySearchRec(array, 0, size - 1, x);
	    
	    if (indexFound == -1)
	    	System.out.println("Number: " + x + " not found!");
	    else
	    	System.out.println("Found number: " + x + " at index: " + indexFound);
	}
	
	public static void bsFirstLastOccurrence() {
		int x = 8;
	    int[] array = {-9, 8, 8, 8, 8, 8, 8, 72, 108, 756, 830};
	    boolean searchFirst = true;
	    
	    int indexFound = bsFirstLastOccur(array, x, searchFirst);
	    
	    if (indexFound == -1)
	    	System.out.println("Number: " + x + " not found!");
	    else {
	    	String firstLast = searchFirst ? "first" : "last";
	    	System.out.println("Found " + firstLast + " occurrence of number: " + x + " at index: " + indexFound);
	    }
	}
	
	public static void bsCountOccurrences() {
		int x = 8;
	    int[] array = {-9, 8, 8, 8, 8, 8, 8, 72, 108, 756, 830};
	    int size = array.length;
	    
	    int count = bsCountOccur(array, size, x);
	    
	    if (count == -1)
	    	System.out.println("Number: " + x + " not found!");
	    else
	    	System.out.println("Found " + count + " occurrences of number " + x + " in the array");
	}
	
	public static void bsRotatedCount() {
		int[] array = {11, 12, 15, 18, 2, 5, 6, 8};
		
		int minIndex = bsFindMinimum(array);
		
		System.out.println("The array is rotated " + minIndex + " times");
	}
	
	public static void bsSearchRotatedArray() {
		int x = 12;
		int[] array = {11, 12, 15, 18, 2, 5, 6, 8};
		
		int indexFound = bsSearchRotated(array, x);
		
		if (indexFound == -1) {
	    	System.out.println("Number: " + x + " not found!");
	    } else {
	    	System.out.println("Found number: " + x + " at index: " + indexFound);
	    }
	}
	
	private static int binarySeachIte(int[] array, int x) {
		int start = 0, end = array.length - 1;
		
		while (start <= end) {
			// calc middle index.
			//int mid = (start + end) / 2;
			int mid = start + (end - start) / 2; // this way to avoid overflow with max integers values
			
			// check if x is equal, smaller or bigger of current mid.
			if (x == array[mid]) {
				// if yes we return the mid index.
				return mid;
			} else if (x < array[mid]) {
				// x if before mid, move end to left part of the array.
				end = mid - 1;
			} else {
				// x is after mid move start to right part of the array.
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRec(int[] array, int start, int end, int x) {
		// base case - if start is less than end then return
	    if (start > end) {
	        return -1;
	    }
	    
	    // calc middle index.
	    //int mid = (start + end) / 2;
	    int mid = start + (end - start) / 2; // this way to avoid overflow with max integers values
	    
	    // check if x is equal, smaller or bigger of current mid.
	    if (x == array[mid]) {
	        return mid; // if x is equal to mid we return the mid index.
	    } else if (x < array[mid]) {
	        // recursion call for the left part of the array
	        return binarySearchRec(array, start, mid - 1, x);
	    } else {
	        return binarySearchRec(array, mid + 1, end, x);
	    }
	}
	
	private static int bsFirstLastOccur(int[] array, int x, boolean searchFirst) {
		int start = 0, end = array.length - 1;
		int result = -1;
		
		while (start <= end) {
			// calc middle index.
	        //int mid = (start + end) / 2;
	        int mid = start + (end - start) / 2; // this way to avoid overflow with max integers values.
			
	        if (x == array[mid]) {
				/*
	             * when i find x:
	             * instead to exit i store the value in a variable and i continue to search
	             * toward left or right to check if there are other values.
	             */
				result = mid;
				if (searchFirst)
					/* first occurrence */
					end = mid - 1;
				else
					/* last occurrence */
					start = mid + 1; 
			} else if (x < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return result;
	}
	
	private static int bsCountOccur(int[] array, int size, int x) {
		int count = -1;
		int firstIndex = bsFirstLastOccur(array, x, true);
		int lastIndex = bsFirstLastOccur(array, x, false);
		
		if (firstIndex != -1)
			count = (lastIndex - firstIndex) + 1;
		
		return count;
	}
		
	/**
	 * The number of rotation is equal of the number of elements before the minimum element,
	 * that it is equal to the index of the minimum element.
	 * 
	 * Find the index of the minimum element -->  number of right rotations of the array.
	 * Array must be sorted and with no duplicates.
	 */
	private static int bsFindMinimum(int[] array) {
		int size = array.length;
		int start = 0, end = size - 1;
		
		while (start <= end) {
			// case 1 --> if first element is smaller than last element it is the minimum.
			if (array[start] <= array[end])
				return start;
			
			// case 2 --> if mid element id smaller than his previous and next element it s the minimum.
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % size;
			int prev = (mid - 1) % size;
			
			if (array[mid] < array[next] && array[mid] < array[prev])
				return mid;
			
			// case 3 --> if mid is smaller than the 'end' element, the minimum will be in the left part of the array.
			else if (array[mid] < array[end])
				end = mid - 1;
			
			// case 4 --> if mid is bigger than the 'start' element, the minimum will be in the right part of the array.
			else if (array[mid] > array[start])
				start = mid + 1;
		}
		
		return -1;
	}
	
	private static int bsSearchRotated(int[] array, int x) {
		int start = 0, end = array.length - 1;
		
		while (start <= end) {
			// calc middle index.
			int mid = start + (end - start) / 2;
			
			// case 1 -->  x is equal of current mid we have found the element
			if (x == array[mid])
				return mid;
			
			// case 2 --> if mid is smaller than the 'end' element, then the right part of the array is sorted.
			if (array[mid] < array[end]) {
				// a) --> if x is grater than mid and smaller than end,
				// x is in the right part of the array (fix start to mid+1).
				if (x > array[mid] && x <= array[end])
					start = mid + 1;
				// b) --> go to search in the (unsorted) left part of the array (fix end to mid-1).
				else
	            	end = mid - 1;
			}
			
			// case 3 --> if mid is bigger than the 'start' element, the left part of the array is sorted.
			else if (array[mid] > array[start]) {
	        	// a) --> if x is grater than start end smaller than mid,
	        	// x is in the left part of the array (fix end to mid-1);
	        	if (x >= array[start] && x < array[mid])
	        		end = mid - 1;
	        	// b) --> go to search in the (unsorted) right part of the array (fix start to mid+1).
	        	else
	        		start = mid + 1;
	        }
		}
		
		return -1;
	}
	

}
