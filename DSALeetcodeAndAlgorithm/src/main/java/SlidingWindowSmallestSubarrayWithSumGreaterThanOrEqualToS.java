package main.java;

public class SlidingWindowSmallestSubarrayWithSumGreaterThanOrEqualToS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2, 1, 5, 2, 3, 2};
		int k=2;
		int sum=0;
		int start=0;
		int smallLength=Integer.MAX_VALUE;
		for(int end=0; end<arr.length; end++) {
			sum+=arr[end];
			while(sum>=k) {
				smallLength=Math.min(smallLength, end-start+1);
				sum-=arr[start];
				start++;
			}
			
			
		}
		System.out.println(smallLength);
	}

}
