package org.gmdev.algorithms.various;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Strings utility algorithms
 */
public class StringUtils {
	
	public static void countVowels() {
		int vowels = countVowels("HEllo Gians");
		System.out.println("Vowels: " + vowels);
	}
	
	public static void reverse() {
		String reversed = reverse("Hello");
		System.out.println(reversed);
	}
	
	public static void reverseWords() {
		String reversed = reverseWords("This is a beautiful day");
		System.out.println(reversed);
	}
	
	public static void areRotations() {
		String str1 = "ABCD";
		String str2 = "DABC";
		boolean rotation = areRotations(str1, str2);
		System.out.println(rotation);
	}
	
	public static void removeDuplicates() {
		String removed = removeDuplicates("Trees are beautiful");
		System.out.println(removed);
	}
	
	public static void getMaxOccurringChar() {
		char ch = getMaxOccurringChar("Good morning");
		System.out.println(ch);
	}
	
	public static void capitalize() {
		String capitalized = capitalize("good afternoon");
		System.out.println(capitalized);
	}
	
	public static void areAnagram1() {
		var result = areAnagram1("ABCD", "BACD");
		System.out.println(result);
	}
	
	public static void areAnagram2() {
		var result = areAnagram2("ABCD", "BACD");
		System.out.println(result);
	}
	
	public static void isPalindrome() {
		var result = isPalindrome("MADAM");
		System.out.println(result);
	}
	
	private static int countVowels(String str) {
		if (str == null)
			return 0;
		
		int count = 0;
		String vowels = "aeiou";
		
		for (var ch : str.toLowerCase().toCharArray())
			if (vowels.indexOf(ch) != -1)
				count++;
				
		return count;
	}
	
	private static String reverse(String str) {
		if (str == null)
			return "";
		
		StringBuilder reversed = new StringBuilder();
		
		for (var i = str.length() - 1; i >= 0; i--)
			reversed.append(str.charAt(i));
		
		return reversed.toString();
	}
	
	private static String reverseWords(String sentense) {
		if (sentense == null)
			return "";
		
		String[] words = sentense.trim().split(" ");
		Collections.reverse(Arrays.asList(words));
		
		return String.join(" ", words);
	}
	
	private static boolean areRotations(String str1, String str2) {
		if (str2 == null || str2 == null)
			return false;
		
		return (str1.length() == str2.length() &&
				(str1 + str1).contains(str2));
	}
	
	private static String removeDuplicates(String str) {
		if (str == null)
			return "";
		
		StringBuilder output = new StringBuilder();
		Set<Character> seen = new HashSet<>();
		
		for (var ch : str.toCharArray()) {
			if (!seen.contains(ch)) {
				seen.add(ch);
				output.append(ch);
			}	
		}	
		
		return output.toString();
	}
	
	private static char getMaxOccurringChar(String str) {
		if (str == null || str.isEmpty())
			throw new IllegalArgumentException();
		
		final int ASCI_SIZE = 256;
		int[] frequencies = new int[ASCI_SIZE];
		
		for (var ch : str.toCharArray())
			frequencies[ch]++;
		
		
		int max = 0;
		char result = ' ';
		for (int i = 0; i < frequencies.length; i ++)
			if (frequencies[i] > max) {
				max = frequencies[i];
				result = (char) i;
			}
		
		return result;
	}
	
	private static String capitalize(String sentence) {
		if (sentence == null || sentence.trim().isEmpty())
			return "";
		
		String[] words = sentence
				.trim()
				.replaceAll(" +", " ")
				.split(" ");
		
		for (var i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + 
					words[i].substring(1).toLowerCase();
		}
		
		return String.join(" ", words);
	}
	
	private static boolean areAnagram1(String first, String second) {
		if (first == null || second == null || first.length() != second.length())
			return false;
		
		var array1 = first.toLowerCase().toCharArray();
		Arrays.sort(array1);
		
		var array2 = second.toLowerCase().toCharArray();
		Arrays.sort(array2);
		
		return Arrays.equals(array1, array2);
	}
	
	private static boolean areAnagram2(String first, String second) {
		if (first == null || second == null || first.length() != second.length())
			return false;
		
		final int ENGLISH_ALPHABET = 26;
		int[] frequencies = new int[ENGLISH_ALPHABET];
		
		first = first.toLowerCase();
		second = second.toLowerCase();
		for (int i = 0; i < first.length(); i++) {
			frequencies[first.charAt(i) - 'a']++;
			frequencies[second.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < ENGLISH_ALPHABET; i++) {
			if (frequencies[i] != 0)
				return false;
		}
			
		return true;
	}
	
	private static boolean isPalindrome(String word) {
		if (word == null)
			return false;
		
		int left = 0;
		int right = word.length() - 1;
		
		while (left < right) {
			if (word.charAt(left++) != word.charAt(right--))
				return false;
		}
			
		return true;
	}
	
	
}




