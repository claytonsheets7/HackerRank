package com.hackerrank.questions;

public class ArrayAlgorithms {
	
	int uniqueInts(int[] arr1, int[] arr2) {
		int uniqueInts = arr1.length + arr2.length;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					arr1[i] = Integer.MIN_VALUE;
					arr2[j] = Integer.MIN_VALUE;
					uniqueInts -= 2;
					break;
				}
			}
		}
		return uniqueInts;
	}

	/*
	 * Tom has a collection of blu-ray discs from volume 1 to n. He is missing
	 * one disc in the collection, but is unsure which one it is. The blu-ray
	 * discs are not ordered. He doesn't have any duplicates in his collection.
	 * Help Tom find out the number of which volume is missing. Write an
	 * algorithm that takes an array of type int, containing the numbers between
	 * 1 and n inclusive and returns the missing number.
	 */
	int missingNumber(int[] arr) {
		// setting to a value that is invalid for the problem
		int missingNumber = -1;

		for (int i = 1; i < arr.length + 1; i++) {
			if (i != arr[i]) {
				missingNumber = i;
				break;
			}
		}

		return missingNumber;
	}

	int largestSumSubarray(int[] arr) {
		int largestSum = Integer.MIN_VALUE;
		int runningSum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				runningSum += arr[i];
			}

			if (runningSum > largestSum) {
				largestSum = runningSum;
			}
		}

		return largestSum;
	}
	
}
