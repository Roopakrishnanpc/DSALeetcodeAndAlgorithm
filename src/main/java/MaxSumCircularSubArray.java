package main.java;

public class MaxSumCircularSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {3,4,6,7,9,-33,-5,-8};
		int currMax=0, currMin=0;
		int maxSum=0, minSum=0;
		int totalSum=0;
		for(int num:nums) {
			totalSum+=num;
			currMax=Math.max(num, num+currMax);
			maxSum=Math.max(currMax, maxSum);
			currMin=Math.min(num, num+currMin);
			minSum=Math.min(currMin, minSum);
		}
		if(totalSum<0) {
			System.out.println(maxSum);
			return;
		}
		System.out.println(Math.max(maxSum, totalSum-minSum));
		
	}

}
