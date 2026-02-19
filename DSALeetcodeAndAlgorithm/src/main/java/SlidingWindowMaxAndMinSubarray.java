package main.java;

public class SlidingWindowMaxAndMinSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1, -2, 3, 4, -1, 2, -5};
		int k=4;
		maxSubArray(arr,k);maxSubArrayApproach2(arr,k);
		minSubArray(arr,k);
	}

	private static void maxSubArrayApproach2(int[] arr, int k) {
		// TODO Auto-generated method stub
		int sum=0, maxLength=0, count=0;
		for(int end=0; end<arr.length; end++) {
			sum+=arr[end];
			count++;
			if(count==k){
				maxLength=Math.max(sum,  maxLength);
				sum-=arr[end-k+1];
				count--;
			}
		}
		System.out.println(maxLength);
	}

	private static void maxSubArray(int[] arr, int k) {
		// TODO Auto-generated method stub
		int maxSum=0;
		for(int end=0; end<k; end++) {
			maxSum+=arr[end];
		}
		int maxLength=maxSum;
		for(int end=k; end<arr.length; end++) {
			maxSum=maxSum-arr[end-k]+arr[end];
			maxLength=Math.max(maxLength, maxSum);
		}
		System.out.println(maxLength);
	}

	private static void minSubArray(int[] arr, int k) {
		// TODO Auto-generated method stub
		int minSum=0;
		for(int end=0; end<k; end++) {
			minSum+=arr[end];
		}
		int minLength=minSum;
		for(int end=k; end<arr.length; end++) {
			minSum=minSum-arr[end-k]+arr[end];
			minLength=Math.min(minLength, minSum);
		}
		System.out.println(minLength);
	}

}
