package main.java;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubArrayWithSumStrictlyLessThanTarget {
	public static void main(String[] args) {
		int[] arr = {4,5,8,9,10,4};
		int target = 28;
		int sum = 0, j = 0, maxLength = 0;

		for (int i = 0; i < arr.length; i++) {
		    sum += arr[i];
		    while (sum >= target) {
		        sum -= arr[j];
		        j++;
		    }
		    maxLength = Math.max(maxLength, i - j + 1);
		}

		System.out.println(maxLength);	
	}
}
