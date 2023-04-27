package org.gmdev.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gmdev.Utils;

/**
 * Bucket sort
 * Sort an array of element distributing them in a k numbers of buckets
 * Then sorting each bucket with another sorting algorithm and then recombining together.  
 * Time complexity vary in base of the number of buckets we use.
 * More buckets -> faster but more memory is needed.
 */
public class BucketSort {
	
	public static void sort() {
		int[] array = {4, 2 , 6, 8, 5, 3, 1, 0};
		bucketSort(array, 3);
		Utils.printIntArray(array);
	}
	
	private static void bucketSort(int[] array, int numberOfBuckets) {
		var buckets = createBuckets(array, numberOfBuckets);
		
		int i = 0;
		for (var bucket : buckets) {
			Collections.sort(bucket);
			
			for (var item : bucket)
				array[i++] = item;
		}
	}
	
	private static List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
		List<List<Integer>> buckets = new ArrayList<>();
		
		for (var i = 0; i < numberOfBuckets; i++)
			buckets.add(new ArrayList<>());
		
		for (var item : array)	
			buckets.get(item / numberOfBuckets).add(item);
		
		return buckets;
	}
	

}
