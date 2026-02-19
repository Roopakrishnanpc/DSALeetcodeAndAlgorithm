package main.java;

public class FindNegativeMaxSubArrayKadanesAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {-2,-3,7,8,9,11,-1,-4};
		int maxLength=0, sum=0;
		for(int i=0; i<arr.length; i++) {
			sum=Math.max(sum+arr[i], arr[i]);
			maxLength=Math.max(maxLength, sum);
		}
		System.out.println(maxLength);
	}
}