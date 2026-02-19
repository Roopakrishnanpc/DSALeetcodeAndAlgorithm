package main.java;

public class LongestSumSubArraysumLessThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0, 1, 2, 4, 5, 5, 7};
		int target=7;
		int sum=0, start=0, maxLength=0;
		for(int end=0; end<arr.length; end++) {
			sum+=arr[end];
			while(start<=end && sum>target) {
				sum-=arr[start];
				start++;
			}
			if(sum<=target) {
				maxLength=Math.max(maxLength, end-start+1);
			}
		}
		System.out.println(maxLength);
	}

}
