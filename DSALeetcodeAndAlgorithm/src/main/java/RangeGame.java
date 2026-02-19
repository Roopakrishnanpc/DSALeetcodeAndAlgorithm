package main.java;

public class RangeGame {
	public static void main(String[] args) {
		int N=7;
		if(N<=0) {
			System.out.println(0);
		}
		int totalSum=N*(N+1)/2;
		int val=Integer.highestOneBit(N);
		System.out.println(val);
		System.out.println(totalSum-val);
	}
}
