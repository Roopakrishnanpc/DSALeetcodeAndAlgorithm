package main.java;

public class MaxAverageSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1, 12, -5, -6, 50, 3};
		int k = 4;
		double sum=0;
		for(int i=0; i<k;i++) {
			sum+=arr[i];
		}
		double maxAverage=sum/k;
		for(int i=k; i<arr.length;i++) {
			sum=sum-arr[i-k]+arr[i];
			maxAverage=Math.max(maxAverage, sum/k);
		}
		System.out.println(maxAverage);
	}

}
