package com.hackerrank.questions;

import java.util.ArrayList;
import java.util.List;

public class MathyAlgorithms {
	
	
	int stringToInteger(String s) throws NumberFormatException {
		if(!s.matches("[0-9]+")) {
			throw new NumberFormatException("Input may only contain integers.");
		}
		
		int integer = 0;
		int multiplier = 1;
		
		char[] integers = s.toCharArray();
		for(int i = integers.length - 1; i >= 0; i--) {
			integer += (integers[i] - 48) * multiplier;
			multiplier *= 10;
		}
		
		return integer;
	}
	
	boolean palindromeInteger(Integer integer) {
		List<Integer> integers = new ArrayList<Integer>();
		Integer copy = integer;
		int modNum = 10;
		while (copy / modNum > 0) {
			integers.add(copy % modNum);
			copy = copy - (copy % modNum);
			copy = copy / 10;
		}
		integers.add(copy);
		
		for(int i = 0; i < integers.size() / 2; i++) {
			if(integers.get(i) != integers.get(integers.size() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * A teacher in a lecture hall asks for every student to shake every other
	 * student's hand. Students are instructed to shake each other student's
	 * hand only once. Write an algorithm that takes n students and returns the
	 * number of handshakes that take place.
	 */
	int handShakeCount(int n) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			count += i;
		}

		return count;
	}

	/*
	 * A mother tells her child that she can choose n shirts from a rack of k
	 * shirts where n is less than or equal to k. How many combinations of
	 * shirts can the child choose? Write an algorithm that takes an int, n,
	 * that represents the number of shirts and returns the number of possible
	 * combinations.
	 */
	int shirtCombinations(int n, int k) {
		int combinations = 1;

		for (int i = n; i >= 0; i--) {
			combinations *= k - i;
		}

		return combinations;
	}
	
	int fibonacci(int n) {
		int next = 0;
		int previous = 0;
		int current = 1;
		while(n >= 1) {
			next = current + previous;
			previous = current;
			current = next;
			System.out.println(next + " " + previous);
			n--;
		}
		return next;
	}
	
	int factorial(int n) {
		if(n > 1) {
			return factorial(n - 1) * n;
		} else {
			return n;
		}
	}

}
