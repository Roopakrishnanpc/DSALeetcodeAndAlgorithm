package main.java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayUnique {
	public static void main(String[] args) {
		int[] arr= {4, 4, 8, 5, 9, 10};
		int target=16, left=0,sum=0,maxLength=0;
		Set<Integer> set=new HashSet<>();
		for(int right=0; right<arr.length; right++) {
			sum += arr[right];
			while(set.contains(arr[right])||sum>=target ) {
				sum-=arr[left];
				set.remove(arr[left]);
				left++;
			}
			set.add(arr[right]);
			maxLength=Math.max(maxLength, right-left+1);
			
		}
		System.out.println(maxLength);
		

	}
}
