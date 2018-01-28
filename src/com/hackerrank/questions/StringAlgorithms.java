package com.hackerrank.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringAlgorithms {
	
	
	Set<String> permutations = new HashSet<String>();
	
	Set<String> generatePermutations(String s) {
		generatePermutations(s, "", 0);
		return permutations;
	}
	
	void generatePermutations(String original, String perm, int startIndex) {
		permutations.add(perm);
		for(int i = startIndex; i < original.length(); i++) {
			String nextPerm = perm + original.charAt(startIndex);
			System.out.println(nextPerm);
			generatePermutations(original, nextPerm, startIndex += 1);
		}
	}

	static int anagramaticPairs(String s) {
		Map<String, Integer> substrings = new HashMap<String, Integer>();
		int anagramaticPairs = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length() + 1; j++) {
				char[] sortedChars = s.substring(i, j).toCharArray();
				Arrays.sort(sortedChars);
				String sortedString = new String(sortedChars);
				if (substrings.get(sortedString) != null) {
					anagramaticPairs = anagramaticPairs + substrings.get(sortedString);
					substrings.put(new String(sortedChars), substrings.get(sortedString) + 1);
				} else {
					substrings.put(new String(sortedChars), 1);
				}
			}
		}

		return anagramaticPairs;
	}

	static void makingAnagrams() {
		Scanner in = new Scanner(System.in);
		StringBuilder sb1 = new StringBuilder(in.nextLine());
		StringBuilder sb2 = new StringBuilder(in.nextLine());

		for (int i = 0; i < sb1.length(); i++) {
			for (int j = 0; j < sb2.length(); j++) {
				if (sb1.charAt(i) == sb2.charAt(j)) {
					sb1.deleteCharAt(i);
					sb2.deleteCharAt(j);
					i--;
					j--;
					break;
				}
			}
		}
		System.out.println(sb1.length() + sb2.length());
	}

	/*
	 * Katie wants to know if her name is spelled the same forward and
	 * backwards. Write an algorithm that will allow Katie and others to find
	 * out if their names are the same forwards and backwards.
	 */
	boolean isPalindrome(String name) {

		for (int i = 0; i < name.length() / 2; i++) {
			if (name.charAt(i) != name.charAt(name.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}

	boolean isPalindrome(String name) {
		if (name.length() < 2) {
			return true;
		}

		if (name.charAt(0) != name.charAt(name.length() - 1)) {
			return false;
		} else {
			return isPalindromeRecursive(name.substring(1, name.length() - 2));
		}
	}

	/*
	 * Two students are playing around in class and want to figure out if their
	 * names contain the same letters and the same number of each letter. Write
	 * an algorithm to help them find out.
	 */
	boolean isAnagram(String s1, String s2) {
		s1 = s2.toLowerCase();
		s2 = s2.toLowerCase();
		char[] s1Chars = s1.toCharArray();
		char[] s2Chars = s2.toCharArray();
		Arrays.sort(s1Chars);
		Arrays.sort(s2Chars);

		return Arrays.equals(s1Chars, s2Chars);
	}

	boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		Map<Character, Integer> s1Map = stringToMap(s1);
		Map<Character, Integer> s2Map = stringToMap(s2);

		if (s1Map.equals(s2Map)) {
			return true;
		} else {
			return false;
		}
	}

	Map<Character, Integer> stringToMap(String s) {
		Map<Character, Integer> sCharacters = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (sCharacters.containsKey(s.charAt(i))) {
				sCharacters.put(s.charAt(i), sCharacters.get(s.charAt(i)) + 1);
			} else {
				sCharacters.put(s.charAt(i), 1);
			}
		}
		return sCharacters;
	}

	static void gameOfThrones() {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
		for (Character c : s.toCharArray()) {
			if (charCounts.get(c) != null) {
				charCounts.put(c, charCounts.get(c) + 1);
			} else {
				charCounts.put(c, 1);
			}
		}

		int mismatched = 0;
		Iterator it = charCounts.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if ((Integer) pair.getValue() % 2 != 0) {
				mismatched++;
			}
		}
		if (mismatched > 1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
	
	void unevenCharCounts(String s) {
		int charMismatches = 0;
		char[] sortedChars = s.toCharArray();
		Arrays.sort(sortedChars);
		char currentChar = sortedChars[0];
		int expectedOccurences = 0;
		int charOccurences = 0;
		for (int i = 0; i < sortedChars.length; i++) {

			if (currentChar != sortedChars[i]) {
				currentChar = sortedChars[i];
				if (charOccurences % 2 != 0) {
					charMismatches++;
					if (charMismatches > 1) {
						System.out.println("NO");
						return;
					}
				} else {
					expectedOccurences = charOccurences;
				}
			} else {
				charOccurences += 1;
			}
		}

		System.out.println("YES");
	}

}
