package org.gmdev.algorithms.various;

import org.gmdev.Utils;

/**
 * Various String permutation algorithms
 */
public class StringPermutations {
	
	private static final int K_MAX = 3; 
	
	public static void combinationsKLength() {
		String set = "abcdefghijklmnopqrstuvwxyz";
		
		//String set = "abcd"; 
		String prefix = "";
	    int set_len = set.length();
	    long[] count = {0};
	    
	    stringCombinationsKLength(set.toCharArray(), prefix, K_MAX, set_len, count);
	}
	
	public static void permutation() {
		String set = "abc"; 
		
		int set_len = set.length();
	    long[] count = {0};
	    
	    stringPermutation(set.toCharArray(), 0, set_len, count);
	}
	
	private static void stringPermutation(char[] set, int start, int set_len, long[] count) {
		// base condition - if start is equal to last element of the array then print and return
	    if (start == set_len-1) {
	    	count[0]++;
	    	System.out.println(String.valueOf(set) + " --> " + count[0]);
	    	return;
	    }
	    
	    for (int i = start; i < set_len; i++) {
	    	Utils.swapCharArray(set, start, i);
	    	stringPermutation(set, start+1, set_len, count);
	    	//backtrack
	    	Utils.swapCharArray(set, start, i);
	    }
	}
	
	private static void stringCombinationsKLength(char[] set, String prefix, int k, int set_len, long[] count) {
		// base condition - if k is equal to 0 then return
		if (k == 0) {
	    	// increase the counter to count all the combinations
	    	count[0]++;
	        System.out.println(prefix + " --> " + count[0]);
	        
	        return;
	    }
		
		for (int i = 0; i < set_len; i++) {
			// next character of input added
			String newPrefix = prefix + set[i];  
			
			stringCombinationsKLength(set, newPrefix, k-1, set_len, count);
		}	
	}
	
	
	
}
